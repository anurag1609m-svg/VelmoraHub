package com.piacart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.piacart.entity.User;
import com.piacart.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    // 🔹 Get logged-in user's profile
    @GetMapping("/profile")
    public User getCurrentUser(Authentication auth) {
        return service.getuser(auth.getName());
    }

    // 🔹 Update own profile
    @PutMapping("/update")
    public User updateUser(Authentication auth,
                           @RequestBody User user) {
        return service.updateuser(auth.getName(), user);
    }

    // 🔹 Delete own account
    @DeleteMapping("/delete")
    public String deleteUser(Authentication auth) {
        return service.deleteuser(auth.getName());
    }

    // 🔹 ADMIN: Get all users
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return service.getalluser();
    }

    // 🔹 ADMIN: Get user by ID
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("get/{id}")
    public User getUserById(@PathVariable Integer id) {
        return service.userbyid(id);
    }
    
    // ADMIN: Delete user by id
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("Delete/{id}")
    public String DeleteUserById(@PathVariable Integer id) {
         service.deleteUserById(id);
         return"User Deleted";
    }
}