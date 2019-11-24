package pl.psomocnik.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
  //  @JsonIgnore
    private String password;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "created")
    private Date created;

    @Column(name = "last_changed")
    private Date lastChanged;

   /* @Column(name = "last_logged_in")
    private Date lastLoggedIn;*/

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.created = new Date();
        this.lastChanged = new Date();
    }

    public User(String username, String email, String password, Role role){
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.created = new Date();
        this.lastChanged = new Date();
       // this.lastLoggedIn = null;
    }

    public User(){}

    public Long getId() {
        return this.id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    /*public String getLastLoggedIn() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(this.lastLoggedIn);
    }

    public void setLastLoggedIn(Date lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }*/
}