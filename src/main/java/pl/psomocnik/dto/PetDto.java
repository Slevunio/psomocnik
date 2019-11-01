package pl.psomocnik.dto;

import pl.psomocnik.model.Disease;

import java.util.ArrayList;
import java.util.List;

public class PetDto {

    public static Double featuresToMatch = 10.0;
    private Long id;
    private String name;
    private String takeInDate;
    private String lastChanged;
    private String species;
    private String sex; //enum
    private Integer age;
    private String canLiveWithOtherDogs;
    private String canLiveWithOtherCats;
    private String canLiveWithKids;
    private Integer activity;
   // private List<String> diseases;
    private List<String> photosUrls;
    private String coat;
    private String fur;
    private String isIll;
    private String additionalNotes;
    private Double matchWithUserAccuracy;

    public PetDto(Long id, String name, String takeInDate, String lastChanged, String species, String sex, Integer age, String canLiveWithOtherDogs, String canLiveWithOtherCats, String canLiveWithKids, Integer activity, /*List<Disease> diseases,*/ List<Long> photosIds, String coat, String fur, String isIll, String additionalNotes) {
        this.id = id;
        this.name = name;
        this.takeInDate = takeInDate;
        this.lastChanged = lastChanged;
        this.species = species;
        this.sex = sex;
        this.age = age;
        this.canLiveWithOtherDogs = canLiveWithOtherDogs;
        this.canLiveWithOtherCats = canLiveWithOtherCats;
        this.canLiveWithKids = canLiveWithKids;
        this.activity = activity;
       // this.diseases = convertDiseases(diseases);
        this.photosUrls = convertPhotoUrls(photosIds);
        this.coat = coat;
        this.fur = fur;
        this.isIll = isIll;
        this.additionalNotes = additionalNotes;
        this.matchWithUserAccuracy = 0.0;
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

    public String getTakeInDate() {
        return takeInDate;
    }

    public void setTakeInDate(String takeInDate) {
        this.takeInDate = takeInDate;
    }

    public String getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(String lastChanged) {
        this.lastChanged = lastChanged;
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

   /* public List<String> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<String> diseases) {
        this.diseases = diseases;
    }*/

    public List<String> getPhotosUrls() {
        return photosUrls;
    }

    public void setPhotosUrls(List<Long> photosIds) {
        this.photosUrls = convertPhotoUrls(photosIds);
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

    public String getIsIll() {
        return isIll;
    }

    public void setIsIll(String isIll) {
        this.isIll = isIll;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public Double getMatchWithUserAccuracy() {
        return matchWithUserAccuracy;
    }

    public void setMatchWithUserAccuracy(Double matchWithUserAccuracy) {
        this.matchWithUserAccuracy = matchWithUserAccuracy;
    }

    private List<String> convertPhotoUrls(List<Long> photosIds) {
        List<String> photosUrls = new ArrayList<>();
        for (Long photoId:photosIds
        ) {
            photosUrls.add("/api/photos/"+photoId);
        }
        return photosUrls;
    }


    private List<String> convertDiseases(List<Disease> diseases) {
        List<String> convertedDiseases = new ArrayList<>();
        for (Disease dis : diseases
        ) {
            convertedDiseases.add(dis.getName());
        }
        return convertedDiseases;
    }
}
