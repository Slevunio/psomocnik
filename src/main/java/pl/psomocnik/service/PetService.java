package pl.psomocnik.service;

import pl.psomocnik.DTO.PetWithPhotosDTO;
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
import java.util.Base64;
import java.util.List;

@Service
public class PetService {
    @Autowired
    PetRepository petRepository;
    @Autowired
    DiseaseRepository diseaseRepository;
    @Autowired
    PhotosRepository photosRepository;

    /*public List<Pet> readPets() {
        List<Pet> pets = new ArrayList<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }*/
    public List<PetWithPhotosDTO> readPets(){
        List<PetWithPhotosDTO> petsWithPhotos = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();
        petRepository.findAll().forEach(pets::add);
        for (Pet pet:pets
             ) {
            petsWithPhotos.add(new PetWithPhotosDTO(pet, encodePhotos(readPhotosByPetId(pet.getId()))));
        }
        return petsWithPhotos;
    }

    public PetWithPhotosDTO readPet(Long id) {
        return new PetWithPhotosDTO(petRepository.findById(id).get(), encodePhotos(readPhotosByPetId(id)));
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

    public List<String> encodePhotos(List<Photo> photos){
        List<String> encodedPhotos = new ArrayList<>();
        for (Photo photo:photos
             ) {
            encodedPhotos.add("data:image/png;charset=utf-8;base64,"+Base64.getEncoder().encodeToString(photo.getData()));
        }
        return encodedPhotos;
    }
}