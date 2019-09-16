package pl.psomocnik.dto;

public class FindPetFormDto {
    private String species;
    private String sex;
    private String age;
    private String canLiveWithOtherDogs;
    private String canLiveWithOtherCats;
    private String canLiveWithKids;
    private String activity;
    private String coat;
    private String fur;
    private String diseases;

    public FindPetFormDto(String species, String sex, String age, String canLiveWithOtherDogs, String canLiveWithOtherCats, String canLiveWithKids, String activity, String coat, String fur, String diseases) {
        this.species = species;
        this.sex = sex;
        this.age = age;
        this.canLiveWithOtherDogs = canLiveWithOtherDogs;
        this.canLiveWithOtherCats = canLiveWithOtherCats;
        this.canLiveWithKids = canLiveWithKids;
        this.activity = activity;
        this.coat = coat;
        this.fur = fur;
        this.diseases = diseases;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
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

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }
}
