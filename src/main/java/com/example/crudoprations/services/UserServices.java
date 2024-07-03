package com.example.crudoprations.services;

import com.example.crudoprations.api.UserRepositry;
import com.example.crudoprations.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired

private UserRepositry userRepositry;

public User CreateUser(User user){
    return userRepositry.save(user);
}

public List<User> CreateUsers (List<User> user){
    return userRepositry.saveAll(user);
}

public User GetUser(int id){
    return userRepositry.findById(id).orElse(null);

}

public List<User> GetUsers(){
    return userRepositry.findAll();

}

public User UpdateUser(User user){

    Optional<User> userOptional = userRepositry.findById(user.getId());
    if(userOptional.isPresent()){
         User oldUser = userOptional.get();
         oldUser.setName(user.getName());
         oldUser.setEmail(user.getEmail());
         userRepositry.save(oldUser);

    }
    else {
        return null;

    }
    return user;
}


public String DeleteUser(int id){
    userRepositry.deleteById(id);

    return "User deleted";
}
}
