package pl.psomocnik.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "pet_name")
    private String name;

    @Column(name = "take_in_date")
    private Date takeInDate;

    @Column(name = "last_changed")
    private Date lastChanged;

    @Column(name = "species")
    private String species;

    @Column(name = "sex")
    private String sex;

    @Column(name = "age")
    private Integer age;

    @Column(name = "can_live_with_other_dogs")
    private String canLiveWithOtherDogs;

    @Column(name = "can_live_with_other_cats")
    private String canLiveWithOtherCats;

    @Column(name = "can_live_with_kids")
    private String canLiveWithKids;

    @Column(name = "activity")
    private Integer activity;     // activity in scale 1-10

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pet_diseases", joinColumns = @JoinColumn(name = "pet_id"), inverseJoinColumns = @JoinColumn(name = "disease_id"))
    private List<Disease> diseases;

    @Column(name = "coat")
    private String coat;

    @Column(name = "fur")
    private String fur;

    Pet() {
    }

    public Pet(String name, Date takeInDate, String species, String sex, Integer age, String canLiveWithOtherDogs, String canLiveWithOtherCats, String canLiveWithKids, Integer activity, String coat, String fur, List<Disease> diseases) {
        this.name = name;
        this.takeInDate = takeInDate;
        this.lastChanged = new Date();
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


    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTakeInDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return simpleDateFormat.format(this.takeInDate);
    }

    public void setTakeInDate(Date takeInDate) {
        this.takeInDate = takeInDate;
    }

    public String getLastChanged() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return simpleDateFormat.format(this.lastChanged);
    }

    public void setLastChanged(Date lastChanged) {
        this.lastChanged = lastChanged;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCanLiveWithOtherDogs() {
        return this.canLiveWithOtherDogs;
    }

    public void setCanLiveWithOtherDogs(String canLiveWithOtherDogs) {
        this.canLiveWithOtherDogs = canLiveWithOtherDogs;
    }

    public String getCanLiveWithOtherCats() {
        return this.canLiveWithOtherCats;
    }

    public void setCanLiveWithOtherCats(String canLiveWithOtherCats) {
        this.canLiveWithOtherCats = canLiveWithOtherCats;
    }

    public String getCanLiveWithKids() {
        return this.canLiveWithKids;
    }

    public void setCanLiveWithKids(String canLiveWithKids) {
        this.canLiveWithKids = canLiveWithKids;
    }

    public Integer getActivity() {
        return this.activity;
    }

    public void setActivity(Integer activity) {
        this.activity = activity;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }

    public String getSpecies() {
        return this.species;
    }

    public void setSpecies(String species) {
        this.species = species;
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
}
