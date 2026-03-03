package com.piacart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piacart.entity.User;
import com.piacart.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

	  @Autowired
	    private UserService service;
	  
	  @GetMapping("/profile")
	  public User getcurrentuser(Authentication auth) {
		  
		  return service.getuser(auth.getName());
	  }
	  
	  // 🔹 Update profile
	    @PutMapping("/update")
	    public User updateUser(Authentication authentication,
	                           @RequestBody User user) {
	        return service.updateuser(authentication.getName(), user);
	    }
	    
	 // 🔹 Delete own account
	    @DeleteMapping("/delete")
	    public String deleteUser(Authentication authentication) {
	        return service.deleteuser(authentication.getName());
	    }

	    // 🔹 Get all users (future admin)
	    @GetMapping("/all")
	    public  List<User> getAllUsers() {
	        return service.getalluser();
	    }

	    // 🔹 Get user by ID (admin)
	    @GetMapping("/{id}")
	    public User getUserById(@PathVariable Integer id) {
	        return service.userbyid(id);
	    }
	    
}
