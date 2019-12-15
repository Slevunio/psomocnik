package pl.psomocnik.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import pl.psomocnik.dto.FindPetFormDto;
import pl.psomocnik.dto.PetDto;
import pl.psomocnik.dao.PetRepository;
import pl.psomocnik.dao.PhotosRepository;
import pl.psomocnik.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.psomocnik.model.Photo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PetService {
    @Autowired
    PetRepository petRepository;

    @Autowired
    PhotosRepository photosRepository;

    public List<PetDto> readPets() {
        List<PetDto> petDTOS = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();
        petRepository.findAll().forEach(pets::add);
        for (Pet pet : pets) {
            petDTOS.add(copyPetToPetDTO(pet));
        }
        return petDTOS;
    }

    public PetDto readPet(Long id) {
        return copyPetToPetDTO(petRepository.findById(id).get());
    }

    public void deletePets(List<Long> ids) {
        for (Long id : ids) {
            List<Photo> photos = new ArrayList<>();
            photos = photosRepository.findByPetId(id);
            for (Photo photo : photos) {
                photosRepository.delete(photo);
            }
            petRepository.deleteById(id);
        }
    }

    public void createPet(Pet pet, List<Photo> photos) throws IOException {

        petRepository.save(pet);
        for (Photo photo : photos) {
            photo.setPet(pet);
            photosRepository.save(photo);
        }
    }

    public void updatePet(PetDto petDto, List<Photo> photos) throws ParseException {
        /**
         * 1. wez id zdjec z nowego petdto 2. wez id zdjec z pet do update 3. usun z
         * bazy zdjecia, ktorych nie ma w nowym petdto
         * 
         */
        Pet petToUpdate = petRepository.findById(petDto.getId()).get();
        List<Long> updatedPhotosIds = getPhotoIdsFromUrls(petDto.getPhotosUrls());
        List<Long> orginalPhotosIds = new ArrayList<>();
        List<Photo> orginalPhotos = new ArrayList<>();
        photosRepository.findAllByOrderByIdAsc().forEach(orginalPhotos::add);
        for (Photo photo : orginalPhotos) {
            orginalPhotosIds.add(photo.getId());
        }
        for (int i = 0; i < updatedPhotosIds.size(); i++) {
            if (updatedPhotosIds.get(i) != orginalPhotosIds.get(i)) {
                photosRepository.deleteById(orginalPhotosIds.get(i));
                orginalPhotosIds.remove(i);
                i--;
            }
        }

        petToUpdate = this.copyPetDTOToPet(petDto);
        petRepository.save(petToUpdate);
        for (Photo photo : photos) {
            photo.setPet(petToUpdate);
            photosRepository.save(photo);
        }
    }

    public List<PetDto> findPet(FindPetFormDto findPetFormDTO) {
        Integer matchWithUserAccuracy;
        List<PetDto> matchedPets = new ArrayList<>();
        PetDto petDTO;
        List<Pet> pets = new ArrayList<>();
        petRepository.findAll().forEach(pets::add);

        for (Pet pet : pets) {
            if (findPetFormDTO.getSpecies().equals(pet.getSpecies())) {
                matchWithUserAccuracy = 0;
                if (findPetFormDTO.getSex().equals(pet.getSex())) {
                    matchWithUserAccuracy++;
                }
                if (findPetFormDTO.getSpecies().equals("Pies")) {
                    if (findPetFormDTO.getAge().equals("Dziecko pies") && pet.getAge() < 2) {
                        matchWithUserAccuracy++;
                    } else if (findPetFormDTO.getAge().equals("Pies") && (pet.getAge() >= 2 && pet.getAge() < 8)) {
                        matchWithUserAccuracy++;
                    } else if (findPetFormDTO.getAge().equals("Pan/Pani pies") && pet.getAge() >= 8) {
                        matchWithUserAccuracy++;
                    }
                } else if (findPetFormDTO.getSpecies().equals("Kot")) {
                    if (findPetFormDTO.getAge().equals("Dziecko kot") && pet.getAge() < 2) {
                        matchWithUserAccuracy++;
                    } else if (findPetFormDTO.getAge().equals("Kot") && (pet.getAge() >= 2 && pet.getAge() < 8)) {
                        matchWithUserAccuracy++;
                    } else if (findPetFormDTO.getAge().equals("Pan/Pani kot") && pet.getAge() >= 8) {
                        matchWithUserAccuracy++;
                    }
                }
                if (findPetFormDTO.getCanLiveWithOtherDogs().toLowerCase()
                        .equals(pet.getCanLiveWithOtherDogs().toLowerCase())) {
                    matchWithUserAccuracy++;
                }
                if (findPetFormDTO.getCanLiveWithOtherCats().toLowerCase()
                        .equals(pet.getCanLiveWithOtherCats().toLowerCase())) {
                    matchWithUserAccuracy++;
                }
                if (findPetFormDTO.getCanLiveWithKids().toLowerCase().equals(pet.getCanLiveWithKids().toLowerCase())) {
                    matchWithUserAccuracy++;
                }
                if (findPetFormDTO.getActivity().equals(">7") && pet.getActivity() > 7
                        || Math.abs(Integer.valueOf(findPetFormDTO.getActivity()) - pet.getActivity()) < 2) {
                    matchWithUserAccuracy++;
                }
                if (findPetFormDTO.getCoat().equals(pet.getCoat())) {
                    matchWithUserAccuracy++;
                }
                if (findPetFormDTO.getFur().equals(pet.getFur())) {
                    matchWithUserAccuracy++;
                }
                if (findPetFormDTO.getIsIll().equals(pet.getIsIll())) {
                    matchWithUserAccuracy++;
                }

                petDTO = copyPetToPetDTO(pet);
                petDTO.setMatchWithUserAccuracy(Math.round(matchWithUserAccuracy / PetDto.featuresToMatch * 100));
                matchedPets.add(petDTO);
            }

        }

        Collections.sort(matchedPets, new Comparator<PetDto>() {
            @Override
            public int compare(PetDto o1, PetDto o2) {
                return o1.getMatchWithUserAccuracy() > o2.getMatchWithUserAccuracy() ? -1
                        : o1.getMatchWithUserAccuracy() > o2.getMatchWithUserAccuracy() ? 1 : 0;
            }
        });
        return matchedPets;
    }

    public List<Long> readPhotosIdsByPetId(Long id) {
        List<Photo> photos = new ArrayList<>();
        List<Long> photosIds = new ArrayList<>();
        photosRepository.findByPetId(id).forEach(photos::add);
        for (Photo photo : photos) {
            photosIds.add(photo.getId());
        }
        return photosIds;
    }

    private PetDto copyPetToPetDTO(Pet pet) {
        PetDto petDTO = new PetDto(pet.getId(), pet.getName(), pet.getTakeInDate(), pet.getLastChanged(),
                pet.getSpecies(), pet.getSex(), pet.getAge(), pet.getCanLiveWithOtherDogs(),
                pet.getCanLiveWithOtherCats(), pet.getCanLiveWithKids(), pet.getActivity(),
                convertPhotoUrls(readPhotosIdsByPetId(pet.getId())), pet.getCoat(), pet.getFur(), pet.getIsIll(),
                pet.getAdditionalNotes(), 0L);
        return petDTO;
    }

    private Pet copyPetDTOToPet(PetDto petDto) throws ParseException {
        Pet pet = new Pet(petDto.getId(), petDto.getName(),
                new SimpleDateFormat("yyyy-MM-dd").parse(petDto.getTakeInDate()), petDto.getSpecies(), petDto.getSex(),
                petDto.getAge(), petDto.getCanLiveWithOtherDogs(), petDto.getCanLiveWithOtherCats(),
                petDto.getCanLiveWithKids(), petDto.getActivity(), petDto.getCoat(), petDto.getFur(), petDto.getIsIll(),
                petDto.getAdditionalNotes());
        return pet;
    }

    private List<String> convertPhotoUrls(List<Long> photosIds) {
        List<String> photosUrls = new ArrayList<>();
        for (Long photoId : photosIds) {
            photosUrls.add("/api/photos/" + photoId);
        }
        return photosUrls;
    }

    private List<Long> getPhotoIdsFromUrls(List<String> urls) {
        List<Long> ids = new ArrayList<>();
        for (String url : urls) {
            ids.add(Long.parseLong(url.split("/")[3]));
        }
        Collections.sort(ids);
        return ids;
    }

    public ResponseEntity<Resource> readPhotoById(Long id) {
        Photo photo = photosRepository.findById(id).get();
        String s = Base64.getEncoder().encodeToString(photo.getData());
        System.out.println(s);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(photo.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + photo.getName() + "\"")
                .body(new ByteArrayResource(photo.getData()));
    }

}