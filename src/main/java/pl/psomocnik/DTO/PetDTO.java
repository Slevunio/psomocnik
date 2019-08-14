package pl.psomocnik.DTO;

import pl.psomocnik.model.Disease;
import pl.psomocnik.model.Photo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class PetDTO {

    private Long id;
    private String name;
    private LocalDateTime takeInDate;
    private String species;
    private String sex; //enum
    private Integer age;
    private String canLiveWithOtherDogs;
    private String canLiveWithOtherCats;
    private String canLiveWithKids;
    private Integer activity;     // activity in scale 1-10
    private List<String> diseases;
    private List<String> photos;

    public PetDTO(Long id, String name, LocalDateTime takeInDate, String species, String sex, Integer age, String canLiveWithOtherDogs, String canLiveWithOtherCats, String canLiveWithKids, Integer activity, List<Disease> diseases, List<Photo> photos) {
        this.id = id;
        this.name = name;
        this.takeInDate = takeInDate;
        this.species = species;
        this.sex = sex;
        this.age = age;
        this.canLiveWithOtherDogs = canLiveWithOtherDogs;
        this.canLiveWithOtherCats = canLiveWithOtherCats;
        this.canLiveWithKids = canLiveWithKids;
        this.activity = activity;
        this.diseases = convertDiseases(diseases);
        this.photos = encodePhotos(photos);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTakeInDate() {
        return takeInDate;
    }

    public void setTakeInDate(LocalDateTime takeInDate) {
        this.takeInDate = takeInDate;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCanLiveWithOtherDogs() {
        return canLiveWithOtherDogs;
    }

    public void setCanLiveWithOtherDogs(String canLiveWithOtherDogs) {
        this.canLiveWithOtherDogs = canLiveWithOtherDogs;
    }

    public String getCanLiveWithOtherCats() {
        return canLiveWithOtherCats;
    }

    public void setCanLiveWithOtherCats(String canLiveWithOtherCats) {
        this.canLiveWithOtherCats = canLiveWithOtherCats;
    }

    public String getCanLiveWithKids() {
        return canLiveWithKids;
    }

    public void setCanLiveWithKids(String canLiveWithKids) {
        this.canLiveWithKids = canLiveWithKids;
    }

    public Integer getActivity() {
        return activity;
    }

    public void setActivity(Integer activity) {
        this.activity = activity;
    }

    public List<String> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<String> diseases) {
        this.diseases = diseases;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    private List<String> convertDiseases(List<Disease> diseases){
        List<String> convertedDiseases = new ArrayList<>();
        for (Disease dis:diseases
             ) {
            convertedDiseases.add(dis.getName());
        }
        return convertedDiseases;
    }
    public List<String> encodePhotos(List<Photo> photos){
        List<String> encodedPhotos = new ArrayList<>();
        for (Photo photo:photos
        ) {
            encodedPhotos.add("data:image/png;charset=utf-8;base64,"+ Base64.getEncoder().encodeToString(photo.getData()));
        }
        return encodedPhotos;
    }
}
