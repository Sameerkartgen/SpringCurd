package com.example.crudoprations.api.controller;

import com.example.crudoprations.api.model.User;
import com.example.crudoprations.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
@Autowired
   private UserServices userServices;

@PostMapping("/addUser")
   public User AddUser(@RequestBody User user) {
       return userServices.CreateUser(user);
   }
@PostMapping("/addUsers")
   public List<User> AddUsers(@RequestBody List<User> users) {
       return userServices.CreateUsers(users);
   }

   @GetMapping("user/{id}")
    public User GetUser(@PathVariable int id) {
    return userServices.GetUser(id);
   }


   @GetMapping("alluser")
    public List<User> GetAllUsers() {
    return userServices.GetUsers();
   }

   @PutMapping("/updateuser")
    public User UpdateUser(@RequestBody User user) {
    return userServices.UpdateUser(user);
   }
    @DeleteMapping("/delete/{id}")

    public String DeleteUser(@PathVariable int id) {
    return userServices.DeleteUser(id);
    }
}
