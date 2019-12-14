package pl.psomocnik.dto;


import java.util.List;


public class PetDto {

    public static Double featuresToMatch = 9.0;
    private Long id;
    private String name;
    private String takeInDate;
    private String lastChanged;
    private String species;
    private String sex;
    private Integer age;
    private String canLiveWithOtherDogs;
    private String canLiveWithOtherCats;
    private String canLiveWithKids;
    private Integer activity;
    private List<String> photosUrls;
    private String coat;
    private String fur;
    private String isIll;
    private String additionalNotes;
    private Long matchWithUserAccuracy;

    public PetDto(){}
    public PetDto(Long id, String name, String takeInDate, String lastChanged, String species, String sex, Integer age, String canLiveWithOtherDogs, String canLiveWithOtherCats, String canLiveWithKids, Integer activity, List<String> photosUrls, String coat, String fur, String isIll, String additionalNotes, Long matchWithUserAccuracy) {
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
        this.photosUrls = photosUrls;
        this.coat = coat;
        this.fur = fur;
        this.isIll = isIll;
        this.additionalNotes = additionalNotes;
        this.matchWithUserAccuracy = 0L;
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

    public List<String> getPhotosUrls() {
        return photosUrls;
    }

    public void setPhotosUrls(List<String> photosUrls) {
        this.photosUrls = photosUrls;
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

    public Long getMatchWithUserAccuracy() {
        return matchWithUserAccuracy;
    }

    public void setMatchWithUserAccuracy(Long matchWithUserAccuracy) {
        this.matchWithUserAccuracy = matchWithUserAccuracy;
    }


}
