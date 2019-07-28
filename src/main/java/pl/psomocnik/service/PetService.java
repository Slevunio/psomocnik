package pl.psomocnik.service;

import org.springframework.web.multipart.MultipartFile;
import pl.psomocnik.dao.DiseaseRepository;
import pl.psomocnik.dao.PetRepository;
import pl.psomocnik.dao.PhotosRepository;
import pl.psomocnik.model.Disease;
import pl.psomocnik.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.psomocnik.model.Photo;

import java.io.Console;
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

    public List<Pet> readPets() {
        List<Pet> pets = new ArrayList<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    public Pet readPet(Long id) {
        return petRepository.findById(id).get();
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

    public void createPet(Pet pet) throws IOException {

        petRepository.save(pet);

    }

    public Pet updatePet(Long id, Pet pet) {
        Pet petToUpdate = readPet(id);
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
        return petRepository.save(petToUpdate);
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
}