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
}
