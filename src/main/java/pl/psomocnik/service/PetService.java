package pl.psomocnik.service;

import pl.psomocnik.DTO.PetDTO;
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
import java.util.List;

@Service
public class PetService {
    @Autowired
    PetRepository petRepository;
    @Autowired
    DiseaseRepository diseaseRepository;
    @Autowired
    PhotosRepository photosRepository;

    public List<PetDTO> readPets(){
        List<PetDTO> petDTOS = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();
        petRepository.findAll().forEach(pets::add);
        for (Pet pet:pets
             ) {
            petDTOS.add(copyPetToPetDTO(pet));
        }
        return petDTOS;
    }

    public PetDTO readPet(Long id) {
        return copyPetToPetDTO(petRepository.findById(id).get());
    }

    public void deletePet(Long id) {
        List<Photo> photos = new ArrayList<>();
        photos = photosRepository.findByPetId(id);
        for (Photo photo:photos
             ) {
            photosRepository.delete(photo);
        }
        petRepository.deleteById(id);
    }

    public void createPet(Pet pet, List<Photo> photos) throws IOException {

        petRepository.save(pet);
        for (Photo photo:photos
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

    public List<Disease> readDiseases() {
        List<Disease> diseases = new ArrayList<>();
        diseaseRepository.findAll().forEach(diseases::add);
        return diseases;
    }

    public Disease readDisease(Long id){
        return diseaseRepository.findById(id).get();
    }

    public Disease createDisease(Disease disease) {
        return diseaseRepository.save(disease);
    }

    public void deleteDisease(Long id) {
        diseaseRepository.deleteById(id);
    }

    public List<Photo> readPhotosByPetId(Long id){
        List<Photo> photos = new ArrayList<>();
        photosRepository.findByPetId(id).forEach(photos::add);
        return photos;
    }


    private PetDTO copyPetToPetDTO(Pet pet){
        PetDTO petDTO = new PetDTO(pet.getId(), pet.getName(), pet.getTakeInDate(),
                pet.getSpecies(), pet.getSex(), pet.getAge(),
                pet.getCanLiveWithOtherDogs(), pet.getCanLiveWithOtherCats(), pet.getCanLiveWithKids(),
                pet.getActivity(), pet.getDiseases(), readPhotosByPetId(pet.getId()));
        return petDTO;
    }
    //stworz petDTO (wszystkie pola tekstowe, obraz jako id zdjecia z bazy)
}