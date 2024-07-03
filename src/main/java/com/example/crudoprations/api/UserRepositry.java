package com.example.crudoprations.api;
import com.example.crudoprations.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositry extends JpaRepository<User, Integer>{
}
