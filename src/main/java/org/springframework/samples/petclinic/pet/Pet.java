package org.springframework.samples.petclinic.pet;

//import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Pets")
public class Pet {
    @Id
    @GeneratedValue
    @Column(name="Id")
    private long id;

    @Column(name="Take_in_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate takeInDate;

    @Column(name="Species")
    private String species;

    @Column(name="Sex")
    private String sex;

    @Column(name="Age")
    private short age;

    @Column(name="Can_live_with_other_dogs")
    private Boolean canLiveWithOtherDogs;

    @Column(name="Can_live_wit_other_cats")
    private Boolean canLiveWithOtherCats;

    @Column(name="Can_live_with_kids")
    private Boolean canLiveWithKids;

    @Column(name="Activity")
    private short activity;     // activity in scale 1-10

    @Column(name="Diseases")
    private String diseases;

    public long getId(){return this.id;}

    public LocalDate getTakeInDate(){return this.takeInDate;}
    public void setTakeInDate(LocalDate takeInDate){this.takeInDate=takeInDate;}

    public String getSex(){return this.sex;}
    public void setSex(String sex){this.species=sex;}

    public short getAge(){return this.age;}
    public void setAge(short age){this.age=age;}

    public Boolean getCanLiveWithOtherDogs(){return this.canLiveWithOtherDogs;}
    public void setCanLiveWithOtherDogs(Boolean canLiveWithOtherDogs){this.canLiveWithOtherDogs=canLiveWithOtherDogs;}

    public Boolean getCanLiveWithOtherCats(){return this.canLiveWithOtherCats;}
    public void setCanLiveWithOtherCats(Boolean canLiveWithOtherCats){this.canLiveWithOtherCats=canLiveWithOtherCats;}

    public Boolean getCanLiveWithKids(){return this.canLiveWithKids;}
    public void setCanLiveWithKids(Boolean canLiveWithKids){this.canLiveWithKids=canLiveWithKids;}

    public short getActivity(){return this.activity;}
    public void setActivity(short activity){this.activity=activity;}

    public String getDiseases(){return this.diseases;}
    public void setDiseases(String diseases){this.diseases=diseases;}


    public String getSpecies(){return this.species;}
    public void setSpecies(String species){this.species=species;}
}
