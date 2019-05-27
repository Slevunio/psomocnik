package pl.psomocnik.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.psomocnik.model.Pet;
import pl.psomocnik.service.PetService;

import java.util.List;

@RestController
public class PetController {
    @Autowired
    PetService petService;

    @GetMapping(value="/pets")
    public List<Pet> readPets(){
        return petService.readPets();
    }

    @GetMapping(value="/pets/{id}")
    public Pet readPet(@PathVariable Long id){
        return petService.readPet(id);
    }

    @PostMapping(value="/pets")
    public void createPet(@RequestBody Pet pet){
        petService.createPet(pet);
    }

    @DeleteMapping(value="/pets/{id}")
    public void deletePet(@PathVariable Long id){
        petService.deletePet(id);
    }
}
