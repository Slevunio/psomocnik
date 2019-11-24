package pl.psomocnik.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import pl.psomocnik.dto.FindPetFormDto;
import pl.psomocnik.dto.PetDto;
import pl.psomocnik.dao.DiseaseRepository;
import pl.psomocnik.dao.PetRepository;
import pl.psomocnik.dao.PhotosRepository;
import pl.psomocnik.model.Disease;
import pl.psomocnik.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.psomocnik.model.Photo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PetService {
    @Autowired
    PetRepository petRepository;
    @Autowired
    DiseaseRepository diseaseRepository;
    @Autowired
    PhotosRepository photosRepository;

    public List<PetDto> readPets() {
        List<PetDto> petDTOS = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();
        petRepository.findAll().forEach(pets::add);
        for (Pet pet : pets
        ) {
            petDTOS.add(copyPetToPetDTO(pet));
        }
        return petDTOS;
    }

    public PetDto readPet(Long id) {
        return copyPetToPetDTO(petRepository.findById(id).get());
    }

    public void deletePets(List<Long> ids) {        
        for (Long id : ids
        ) {
            List<Photo> photos = new ArrayList<>();
            photos = photosRepository.findByPetId(id);
            for (Photo photo : photos
            ) {
                photosRepository.delete(photo);
            }
            petRepository.deleteById(id);
        }
    }

    public void createPet(Pet pet, List<Photo> photos) throws IOException {

        petRepository.save(pet);
        for (Photo photo : photos
        ) {
            photo.setPet(pet);
            photosRepository.save(photo);
        }
    }

    public Pet updatePet(Long id, Pet pet) {
      /*  Pet petToUpdate = readPet(id);
        if (!pet.getName().equals(""))
            petToUpdate.setName(pet.getName());
        if (pet.getTakeInDate() != null)
            petToUpdate.setTakeInDate(pet.getTakeInDate());
        if (!pet.getSpecies().equals(""))
            petToUpdate.setSpecies(pet.getSpecies());
        if (!pet.getSex().equals(""))
            petToUpdate.setSex(pet.getSex());
        if (pet.getAge() != null)
            petToUpdate.setAge(pet.getAge());
        if (!pet.getCanLiveWithOtherDogs().equals(""))
            petToUpdate.setCanLiveWithOtherDogs(pet.getCanLiveWithOtherDogs());
        if (!pet.getCanLiveWithOtherCats().equals(""))
            petToUpdate.setCanLiveWithOtherCats(pet.getCanLiveWithOtherCats());
        if (!pet.getCanLiveWithKids().equals(""))
            petToUpdate.setCanLiveWithKids(pet.getCanLiveWithKids());
        if (pet.getActivity() != null)
            petToUpdate.setActivity(pet.getActivity());
        if (!pet.getDiseases().equals(""))
            petToUpdate.setDiseases(pet.getDiseases());
        return petRepository.save(petToUpdate);*/
        return null;
    }

    public List<PetDto> findPet(FindPetFormDto findPetFormDTO) {
        Integer matchWithUserAccuracy;
        List<PetDto> matchedPets = new ArrayList<>();
        PetDto petDTO;
        List<Pet> pets = new ArrayList<>();
        petRepository.findAll().forEach(pets::add);

        for (Pet pet : pets
        ) {
            if (findPetFormDTO.getSpecies().equals(pet.getSpecies())) {
                matchWithUserAccuracy = 0;
                if (findPetFormDTO.getSex().equals(pet.getSex())) {
                    matchWithUserAccuracy++;
                }
                if (findPetFormDTO.getSpecies().equals("Pies")) {
                    if(findPetFormDTO.getAge().equals("Dziecko pies") && pet.getAge()<2){
                        matchWithUserAccuracy++;
                    }
                    else if(findPetFormDTO.getAge().equals("Pies") && (pet.getAge() >=2 && pet.getAge() < 8)){
                        matchWithUserAccuracy++;
                    }
                    else if(findPetFormDTO.getAge().equals("Pan/Pani pies") && pet.getAge()>=8){
                        matchWithUserAccuracy++;
                    }
                }
                else if (findPetFormDTO.getSpecies().equals("Kot")) {
                    if(findPetFormDTO.getAge().equals("Dziecko kot") && pet.getAge()<2){
                        matchWithUserAccuracy++;
                    }
                    else if(findPetFormDTO.getAge().equals("Kot") && (pet.getAge() >=2 && pet.getAge() < 8)){
                        matchWithUserAccuracy++;
                    }
                    else if(findPetFormDTO.getAge().equals("Pan/Pani kot") && pet.getAge()>=8){
                        matchWithUserAccuracy++;
                    }
                }
                if (findPetFormDTO.getCanLiveWithOtherDogs().toLowerCase().equals(pet.getCanLiveWithOtherDogs().toLowerCase())) {
                    matchWithUserAccuracy++;
                }
                if (findPetFormDTO.getCanLiveWithOtherCats().toLowerCase().equals(pet.getCanLiveWithOtherCats().toLowerCase())) {
                    matchWithUserAccuracy++;
                }
                if (findPetFormDTO.getCanLiveWithKids().toLowerCase().equals(pet.getCanLiveWithKids().toLowerCase())) {
                    matchWithUserAccuracy++;
                }
                if (findPetFormDTO.getActivity().equals(">7") && pet.getActivity() > 7 || Math.abs(Integer.valueOf(findPetFormDTO.getActivity()) - pet.getActivity()) < 2) {
                    matchWithUserAccuracy++;
                }
                if (findPetFormDTO.getCoat().equals(pet.getCoat())) {
                    matchWithUserAccuracy++;
                }
                if (findPetFormDTO.getFur().equals(pet.getFur())) {
                    matchWithUserAccuracy++;
                }
                if(findPetFormDTO.getIsIll().equals(pet.getIsIll())){
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
                return o1.getMatchWithUserAccuracy() > o2.getMatchWithUserAccuracy() ? -1 :
                        o1.getMatchWithUserAccuracy() > o2.getMatchWithUserAccuracy() ? 1 : 0;
            }
        });
        return matchedPets;
    }

    public List<Disease> readDiseases() {
        List<Disease> diseases = new ArrayList<>();
        diseaseRepository.findAll().forEach(diseases::add);
        return diseases;
    }

    public Disease readDisease(Long id) {
        return diseaseRepository.findById(id).get();
    }

    public Disease createDisease(Disease disease) {
        return diseaseRepository.save(disease);
    }

    public void deleteDisease(Long id) {
        diseaseRepository.deleteById(id);
    }

    public List<Long> readPhotosIdsByPetId(Long id) {
        List<Photo> photos = new ArrayList<>();
        List<Long> photosIds = new ArrayList<>();
        photosRepository.findByPetId(id).forEach(photos::add);
        for (Photo photo : photos
        ) {
            photosIds.add(photo.getId());
        }
        return photosIds;
    }


    private PetDto copyPetToPetDTO(Pet pet) {
        PetDto petDTO = new PetDto(pet.getId(), pet.getName(), pet.getTakeInDate(), pet.getLastChanged(),
                pet.getSpecies(), pet.getSex(), pet.getAge(),
                pet.getCanLiveWithOtherDogs(), pet.getCanLiveWithOtherCats(), pet.getCanLiveWithKids(),
                pet.getActivity(), /*pet.getDiseases(),*/ readPhotosIdsByPetId(pet.getId()), pet.getCoat(), pet.getFur(),pet.getIsIll(), pet.getAdditionalNotes());
        return petDTO;
    }

    public ResponseEntity<Resource> readPhotoById(Long id) {
        Photo photo = photosRepository.findById(id).get();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(photo.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + photo.getName() + "\"")
                .body(new ByteArrayResource(photo.getData()));
    }

}