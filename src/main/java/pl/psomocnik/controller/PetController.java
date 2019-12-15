package pl.psomocnik.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import pl.psomocnik.dto.FindPetFormDto;
import pl.psomocnik.dto.PetDto;
import pl.psomocnik.model.Photo;
import pl.psomocnik.service.PetService;
import pl.psomocnik.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController

@RequestMapping("/api")

public class PetController {
    @Autowired
    PetService petService;

    @GetMapping(value = "/pet")
    public List<PetDto> readPets() {
        return petService.readPets();
    }

    @GetMapping(value = "/pet/{id}")
    public PetDto readPet(@PathVariable Long id) {
        return petService.readPet(id);
    }

    @PostMapping(value = "/pet")
    public void createPet(@RequestParam("name") String name, @RequestParam("takeInDate") String takeInDate,
            @RequestParam("species") String species, @RequestParam("sex") String sex, @RequestParam("age") String age,
            @RequestParam("canLiveWithOtherDogs") String canLiveWithOtherDogs,
            @RequestParam("canLiveWithOtherCats") String canLiveWithOtherCats,
            @RequestParam("canLiveWithKids") String canLiveWithKids, @RequestParam("activity") String activity,
            @RequestParam("coat") String coat, @RequestParam("fur") String fur, @RequestParam("isIll") String isIll,
            @RequestParam("additionalNotes") String additionalNotes, @RequestParam("photos") MultipartFile[] photos)
            throws IOException, ParseException {
        petService.createPet(new Pet(name, convertDate(takeInDate), species, sex, Integer.valueOf(age),
                canLiveWithOtherDogs, canLiveWithOtherCats, canLiveWithKids, Integer.valueOf(activity), coat, fur,
                isIll, additionalNotes), convertPhotos(photos));
    }

    @PutMapping(value = "/pet/{id}")
    public void updatePet(@RequestParam("pet") String petJsonString,
            @RequestParam("addedPhotos") MultipartFile[] photos) throws IOException, ParseException {
        PetDto petDto = new ObjectMapper().readValue(petJsonString, PetDto.class);
        petService.updatePet(petDto, convertPhotos(photos));
    }

    @DeleteMapping(value = "/pet")
    public void deletePet(@RequestParam String ids) {
        petService.deletePets(convertToArray(ids));
    }

    @GetMapping(value = "/photos/{id}")
    public ResponseEntity<Resource> readPhoto(@PathVariable Long id) throws IOException {
        return petService.readPhotoById(id);
    }

    @PostMapping(value = "/findPet")
    public List<PetDto> findPet(@RequestBody FindPetFormDto findPetFormDTO) {
        return petService.findPet(findPetFormDTO);
    }

    private Date convertDate(String dateString) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
    }

    private List<Photo> convertPhotos(MultipartFile[] multipartFileList) throws IOException {
        List<Photo> photos = new ArrayList<>();

        for (int i = 0; i < multipartFileList.length; i++) {
            photos.add(new Photo(multipartFileList[i].getOriginalFilename(), multipartFileList[i].getContentType(),
                    multipartFileList[i].getBytes()));
        }
        return photos;
    }

    private List<Long> convertToArray(String idsString) {
        List<Long> ids = new ArrayList<>();
        String[] splitted = idsString.substring(1, idsString.length() - 1).split(",");
        for (String id : splitted) {
            ids.add(Long.valueOf(id));
        }
        return ids;
    }
}
