package org.springframework.samples.petclinic.user;



import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @Column(name="Type")
    private short type;     //0=registered user; 1=moderator; 2=admin

    @Column(name="User_name")
    private String userName;

    @Column(name="Email")
    private String email;

    @Column(name="Created")
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private LocalDate created;

    @Column(name="Last_changed")
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private LocalDate lastChanged;

    @Column(name="Matched_pets_ids")
    private List<Integer> matchedPetsIds;   //sorted best matches to worst matches | QESTION: Where should I put sorting implementation?

    public int getId(){ return this.id; }

    public void setType(short type){ this.type=type; }
    public short getType(){return this.type;}

    public void setUserName(String userName) {this.userName=userName;}
    public String getUserName(){return this.userName;}

    public void setEmail(String email){this.email=email;}
    public String getEmail(){return this.email;}

    public LocalDate getCreated(){return this.created;}

    public void setLastChanged(LocalDate lastChanged){this.lastChanged=lastChanged;}
    public LocalDate getLastChanged(){return this.lastChanged;}

    public void setMatchedPetsIds(List<Integer> matchedPetsIds){this.matchedPetsIds=matchedPetsIds;}
    public List<Integer> getMatchedPetsIds(){return this.matchedPetsIds;}

    User(){this.created=LocalDate.now();}

}
