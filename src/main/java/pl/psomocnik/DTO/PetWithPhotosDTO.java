package pl.psomocnik.DTO;

import pl.psomocnik.model.Pet;
import pl.psomocnik.model.Photo;

import java.util.ArrayList;
import java.util.List;

public class PetWithPhotosDTO {

    private Pet pet;
    private List<String> photos;

    public PetWithPhotosDTO(Pet pet, List<String> photos) {
        this.pet = pet;
        this.photos = photos;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }
}
