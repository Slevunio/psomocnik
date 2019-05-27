package pl.psomocnik.api;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class MainController {

    @GetMapping("/manageUsers")
    public String manageUsers() {
        return "users/manageUsers";
    }

    @GetMapping("/addUser")
    public String addUser(){
        return "users/addUser";
    }

    @GetMapping("/editUser/{id}")
    public String editUser(){
        return "users/editUser";
    }

    @GetMapping("/managePets")
    public String managePets(){
        return "pets/managePets";
    }

    @GetMapping("/addPet")
    public String addPet(){
        return "pets/addPet";
    }

    @GetMapping("/editPet/{id}")
    public String editPet(){return "pets/editPet";}
}

