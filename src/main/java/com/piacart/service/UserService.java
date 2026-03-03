package com.piacart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.piacart.dto.LoginResponse;
import com.piacart.entity.User;
import com.piacart.repository.UserRepository;
import com.piacart.security.JwtUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtil jwtUtil;

    public User register(User user) {

        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("USER");

        return repo.save(user);
    }

    public LoginResponse login(String email, String password) {

        User user = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole());

        return new LoginResponse(token);
    }
    
    //view user
    public User getuser(String email) {
    	
    	return repo.findByEmail(email)
    			.orElseThrow(()->new RuntimeException("User Not found"));
    }
    
    // update user
    public User updateuser(String email,User updateuser) {
    	
    	User exsistinguser=repo.findByEmail(email)
    			.orElseThrow(()->new RuntimeException("User Not found"));
    	
    	exsistinguser.setName(updateuser.getName());
    	
    	if(updateuser.getPassword()!=null&& !updateuser.getPassword().isEmpty() ) {
    		exsistinguser.setPassword(encoder.encode(updateuser.getPassword()));
    	}
   return 	repo.save(exsistinguser);
    }
    
    public String deleteuser(String email) {
    	  repo.deleteByEmail(email);
    	  return"User deleted successfully";
    }
    
    
    //admin section
    
    public List<User> getalluser(){
    return	 repo.findAll();
    	 
    }
    
    public User userbyid( Integer  id) {
    	 return repo.findById(id)
    			 .orElseThrow(()->new RuntimeException("User Not found"));
    }
    
    public String deleteUserById(Integer id) {

        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Optional: prevent deleting admin
        if (user.getRole().equalsIgnoreCase("ADMIN")) {
            throw new RuntimeException("Admin cannot be deleted");
        }

        repo.delete(user);

        return "User deleted successfully";
    }
}