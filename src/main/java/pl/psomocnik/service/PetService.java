package pl.psomocnik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.psomocnik.dao.PetRepository;
import pl.psomocnik.model.Pet;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {
    @Autowired
    PetRepository petRepository;

    public List<Pet> readPets(){
        List<Pet> pets=new ArrayList<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    public Pet readPet(Long id){
        return petRepository.findById(id).get();
    }

    public void deletePet(Long id){
        petRepository.deleteById(id);
    }
    public void createPet(Pet pet){
        petRepository.save(pet);
    }
    public Pet updatePet(Long id, Pet pet){
        Pet petToUpdate=readPet(id);
        if(!pet.getName().equals(""))
            petToUpdate.setName(pet.getName());
        if(pet.getTakeInDate()!=null)
            petToUpdate.setTakeInDate(pet.getTakeInDate());
        if(!pet.getSpecies().equals(""))
            petToUpdate.setSpecies(pet.getSpecies());
        if(!pet.getSex().equals(""))
            petToUpdate.setSex(pet.getSex());
        if(pet.getAge()!=null)
            petToUpdate.setAge(pet.getAge());
        if(!pet.getCanLiveWithOtherDogs().equals(""))
            petToUpdate.setCanLiveWithOtherDogs(pet.getCanLiveWithOtherDogs());
        if(!pet.getCanLiveWithOtherCats().equals(""))
            petToUpdate.setCanLiveWithOtherCats(pet.getCanLiveWithOtherCats());
        if(!pet.getCanLiveWithKids().equals(""))
            petToUpdate.setCanLiveWithKids(pet.getCanLiveWithKids());
        if(pet.getActivity()!=null)
            petToUpdate.setActivity(pet.getActivity());
        if(!pet.getDiseases().equals(""))
            petToUpdate.setDiseases(pet.getDiseases());
        return petRepository.save(petToUpdate);
    }
}
