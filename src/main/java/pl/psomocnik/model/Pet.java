package pl.psomocnik.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="pet_name")
    private String name;

    @Column(name = "take_in_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime takeInDate;

    @Column(name = "species")
    private String species;

    @Column(name = "sex")
    private String sex; //enum

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

    @Column(name = "diseases")
    private String diseases;


    //dodac osobna encje pictures


    public Long getId() {
        return this.id;
    }

    public String getName(){return this.name;}

    public void setName(String name){this.name=name;}

    public LocalDateTime getTakeInDate() {
        return this.takeInDate;
    }

    public void setTakeInDate(LocalDateTime takeInDate) {
        this.takeInDate = takeInDate;
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

    public String getDiseases() {
        return this.diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }


    public String getSpecies() {
        return this.species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

}
