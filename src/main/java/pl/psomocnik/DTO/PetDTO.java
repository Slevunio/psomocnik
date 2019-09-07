package pl.psomocnik.DTO;

import pl.psomocnik.model.Disease;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PetDTO {

    public static Double featuresToMatch = 10.0;
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
    private List<Long> photosIds; // lista id
    private String coat;
    private String fur;
    private Double percentageMatchWithUserAccuracy;

    public PetDTO(Long id, String name, LocalDateTime takeInDate, String species, String sex, Integer age, String canLiveWithOtherDogs, String canLiveWithOtherCats, String canLiveWithKids, Integer activity, List<Disease> diseases, List<Long> photosIds, String coat, String fur) {
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
        this.photosIds = photosIds;
        this.coat = coat;
        this.fur = fur;
        this.percentageMatchWithUserAccuracy = 0.0;
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

    public List<Long> getPhotosIds() {
        return photosIds;
    }

    public void setPhotosIds(List<Long> photosIds) {
        this.photosIds = photosIds;
    }

    private List<String> convertDiseases(List<Disease> diseases) {
        List<String> convertedDiseases = new ArrayList<>();
        for (Disease dis : diseases
        ) {
            convertedDiseases.add(dis.getName());
        }
        return convertedDiseases;
    }

    public String getCoat() {
        return coat;
    }

    public void setCoat(String coat) {
        this.coat = coat;
    }

    public String getFur() {
        return fur;
    }

    public void setFur(String fur) {
        this.fur = fur;
    }

    public Double getPercentageMatchWithUserAccuracy() {
        return percentageMatchWithUserAccuracy;
    }

    public void setPercentageMatchWithUserAccuracy(Double percentageMatchWithUserAccuracy) {
        this.percentageMatchWithUserAccuracy = percentageMatchWithUserAccuracy;
    }
}
