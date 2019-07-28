package pl.psomocnik.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import pl.psomocnik.model.Disease;
import pl.psomocnik.model.Photo;
import pl.psomocnik.service.PetService;
import pl.psomocnik.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController

@RequestMapping("/api")

public class PetController {
    @Autowired
    PetService petService;

    @GetMapping(value = "/pet")
    public List<Pet> readPets() {
        return petService.readPets();
    }


    @GetMapping(value = "/pet/{id}")
    public Pet readPet(@PathVariable Long id) {
        return petService.readPet(id);
    }


    @PostMapping(value = "/pet")
    public void createPet(@RequestParam("name") String name,
                          @RequestParam("takeInDate") String takeInDate,
                          @RequestParam("species") String species,
                          @RequestParam("sex") String sex,
                          @RequestParam("age") String age,
                          @RequestParam("canLiveWithOtherDogs") String canLiveWithOtherDogs,
                          @RequestParam("canLiveWithOtherCats") String canLiveWithOtherCats,
                          @RequestParam("canLiveWithKids") String canLiveWithKids,
                          @RequestParam("activity") String activity,
                          @RequestParam("diseases") String diseases,
                          @RequestParam("photos") List<MultipartFile> photos) throws IOException {
        petService.createPet(new Pet(name, convertDate(takeInDate), species, sex, Integer.valueOf(age), canLiveWithOtherDogs, canLiveWithOtherCats, canLiveWithKids, Integer.valueOf(activity), convertDiseases(diseases), convertPhotos(photos)));
    }

    @PutMapping(value = "/pet/{id}")
    public Pet updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        return petService.updatePet(id, pet);
    }

    @DeleteMapping(value = "/pet/{id}")
    public void deletePet(@PathVariable Long id) {
        petService.deletePet(id);
    }

    @GetMapping(value = "/disease")
    public List<Disease> readDiseases() {
        return petService.readDiseases();
    }

    @PostMapping(value = "/disease")
    public Disease createDisease(@RequestBody Disease disease) {
        return petService.createDisease(disease);
    }

    @DeleteMapping(value = "/disease/{id}")
    public void deleteDisease(@PathVariable Long id) {
        petService.deleteDisease(id);
    }

    private List<Disease> convertDiseases(String diseasesString) {
        List<Disease> diseases = new ArrayList<>();
        String[] splittedDiseases = diseasesString.split(",");
        for (int i = 0; i < splittedDiseases.length; i+=2) {
            Long id = Long.valueOf(splittedDiseases[i].split(":")[1]);
            diseases.add(petService.readDisease(id));
        }
        return diseases;
    }

    private LocalDateTime convertDate(String dateString){
        String[] splittedDate = dateString.split("T");
        String joinedDate = String.join(" ", splittedDate);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(joinedDate, dateTimeFormatter);
    }

    private List<Photo> convertPhotos(List<MultipartFile> multipartFileList) throws IOException {
        List<Photo> photos = new ArrayList<>();
        for (MultipartFile file:multipartFileList
             ) {
            photos.add(new Photo(file.getOriginalFilename(), file.getContentType(), file.getBytes()));
        }
        return photos;
    }
}
