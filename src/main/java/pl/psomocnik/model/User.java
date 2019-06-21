package pl.psomocnik.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String username;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name="user_role")
    private String role;

    @Column(name = "created")
    private Date created;

    @Column(name = "last_changed")
    private Date lastChanged;

    //string pass
/*
    @ElementCollection(targetClass = java.lang.Integer.class)
    @Column(name = "matched_pets_ids")
    private List<Integer> matchedPetsIds = new ArrayList<>();   //sorted best->worst | Gdzie będzie implementacja sortowania?
*/

    public User(String username, String email, String role) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.created = new Date();
        this.lastChanged = new Date();
    }

    public User(Long id, String username, String email, String password, String role){
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.created = new Date();
        this.lastChanged = new Date();
    }

    public User(){};

    public Long getId() {
        return this.id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCreated() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(this.created);
    }

    public void setLastChanged(Date lastChanged) {
        this.lastChanged = lastChanged;
    }

    public String getLastChanged() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
