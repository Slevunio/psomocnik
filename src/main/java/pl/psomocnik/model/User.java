package pl.psomocnik.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; //Long

    @Column(name = "user_type")
    private String type;     //0=registered user; 1=moderator; 2=admin //w string enum

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "created")
    private Date created;

    @Column(name = "last_changed")
    private Date lastChanged;
/*
    @ElementCollection(targetClass = java.lang.Integer.class)
    @Column(name = "matched_pets_ids")
    private List<Integer> matchedPetsIds = new ArrayList<>();   //sorted best->worst | Gdzie będzie implementacja sortowania?
*/

   public User(String userName, String type, String email){
       this.userName=userName;
       this.type=type;
       this.email=email;
       this.created=new Date();
       this.lastChanged=new Date();
   }
    public User(Long id, String userName, String type, String email){
        this.id=id;
        this.userName=userName;
        this.type=type;
        this.email=email;
        this.created=new Date();
        this.lastChanged=new Date();
    }
   public User(){}
    public Long getId() {
        return this.id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    /*public void setPassword(String password){
       this.password=password;
    }

    public String getPassword(){
       return this.password;
    }
*/
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCreated() {
       SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       return simpleDateFormat.format(this.created);
    }

    public void setLastChanged(Date lastChanged) {
        this.lastChanged = lastChanged;
    }

    public String getLastChanged() {
       SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       return simpleDateFormat.format(this.lastChanged);
    }

   /* public void setMatchedPetsIds(List<Integer> matchedPetsIds) {
        this.matchedPetsIds = matchedPetsIds;
    }

    public List<Integer> getMatchedPetsIds() {
        return this.matchedPetsIds;
    }
    */

}
