package com.milorad.restapi.Controller;

import com.milorad.restapi.Models.User;
import com.milorad.restapi.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/") //vrednost end pointa "/" - default value
    public String getPage(){

        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUserRepo() {
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){

        userRepo.save(user);
        return "Saved..";

    }

    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){

        User updatedUser = userRepo.findById(id).get();

        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setOccupation(user.getOccupation());
        updatedUser.setAge(user.getAge());
        userRepo.save(updatedUser);
        return "Updated";

    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){

        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);

        return "Deleted user with ID: "+id;

    }

}
