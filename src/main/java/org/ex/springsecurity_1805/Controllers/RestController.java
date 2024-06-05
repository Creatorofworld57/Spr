package ex.springsecurity_1805.Controllers;


import ex.springsecurity_1805.Models.Application;
import ex.springsecurity_1805.Models.Usermain;
import ex.springsecurity_1805.servisies.ServiceApp;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private ServiceApp serviceApp;
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    //@GetMapping("/{id}")
    //public Application applicationByID(@PathVariable int id){
     //   return serviceApp.applicationById(id);
    //}

    @PostMapping("/newUserPost")
    public void addUser(@RequestBody Usermain user){
        serviceApp.addUser(user);
    }


}
