package pl.psomocnik.api;

import pl.psomocnik.service.PetService;
import pl.psomocnik.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api")

public class PetController {
    @Autowired
    PetService petService;

    @GetMapping(value="/pet")
    public List<Pet> readPets(){
        return petService.readPets();
    }


    @GetMapping(value="/pet/{id}")
    public Pet readPet(@PathVariable Long id){
        return petService.readPet(id);
    }


    @PostMapping(value="/pet")
    public void createPet(@RequestBody Pet pet){
        petService.createPet(pet);
    }


    @PutMapping(value="/pet/{id}")
    public Pet updatePet(@PathVariable Long id, @RequestBody Pet pet){
        return petService.updatePet(id, pet);
    }

    @DeleteMapping(value="/pet/{id}")
    public void deletePet(@PathVariable Long id){
        petService.deletePet(id);
    }
}
