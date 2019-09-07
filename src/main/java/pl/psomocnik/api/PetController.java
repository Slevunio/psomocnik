package pl.psomocnik.api;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import pl.psomocnik.DTO.FindPetFormDTO;
import pl.psomocnik.DTO.PetDTO;
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

@RestController

@RequestMapping("/api")

public class PetController {
    @Autowired
    PetService petService;

    @GetMapping(value = "/pet")
    public List<PetDTO> readPets() {
        return petService.readPets();
    }

    /*@GetMapping(value = "/photos/{id}")
    public List<Photo> readPhotosByPetId(Long id){
        return petService.readPhotosByPetId(id);
    }*/


    @GetMapping(value = "/pet/{id}")
    public PetDTO readPet(@PathVariable Long id) {
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
                          @RequestParam("coat") String coat,
                          @RequestParam("fur") String fur,
                          @RequestParam("diseases") String diseases,
                          @RequestParam("photos") MultipartFile[] photos) throws IOException {
        petService.createPet(new Pet(name, convertDate(takeInDate), species,
                sex, Integer.valueOf(age), canLiveWithOtherDogs,
                canLiveWithOtherCats, canLiveWithKids, Integer.valueOf(activity), coat, fur, convertDiseases(diseases)), convertPhotos(photos));
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

    @GetMapping(value = "/photos/{id}")
    public ResponseEntity<Resource> readPhoto(@PathVariable Long id) throws IOException {
        return petService.readPhotoById(id);
    }

    @PostMapping(value = "/findPet")
    public List<PetDTO> findPet(/*@RequestParam("species") String species,
                                @RequestParam("sex") String sex,
                                @RequestParam("age") String age,
                                @RequestParam("canLiveWithOtherDogs") String canLiveWithOtherDogs,
                                @RequestParam("canLiveWithOtherCats") String canLiveWithOtherCats,
                                @RequestParam("canLiveWithKids") String canLiveWithKids,
                                @RequestParam("activity") String activity,
                                @RequestParam("coat") String coat,
                                @RequestParam("fur") String fur,
                                @RequestParam("diseases") String diseases*/
                                    @RequestBody FindPetFormDTO findPetFormDTO){
        return petService.findPet(findPetFormDTO);
    }

    private List<Disease> convertDiseases(String diseasesString) {
        List<Disease> diseases = new ArrayList<>();
        String[] splittedDiseases = diseasesString.split(",");
        for (int i = 0; i < splittedDiseases.length; i += 2) {
            Long id = Long.valueOf(splittedDiseases[i].split(":")[1]);
            diseases.add(petService.readDisease(id));
        }
        return diseases;
    }

    private LocalDateTime convertDate(String dateString) {
        String[] splittedDate = dateString.split("T");
        String joinedDate = String.join(" ", splittedDate);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(joinedDate, dateTimeFormatter);
    }

    private List<Photo> convertPhotos(MultipartFile[] multipartFileList) throws IOException {
        List<Photo> photos = new ArrayList<>();

        for (int i = 0; i < multipartFileList.length; i++) {
            photos.add(new Photo(multipartFileList[i].getOriginalFilename(), multipartFileList[i].getContentType(), multipartFileList[i].getBytes()));
        }
        return photos;
    }
}
