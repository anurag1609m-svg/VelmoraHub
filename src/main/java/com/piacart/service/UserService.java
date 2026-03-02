package com.piacart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.piacart.config.SecurityConfig;
import com.piacart.entity.User;
import com.piacart.repository.UserRepository;
import com.piacart.security.JwtUtil;

@Service
public class UserService  {
 
    @Autowired
    private  UserRepository us;
    @Autowired
    private PasswordEncoder ps ;
	
    public User register(User u) {
    	u.setPassword(ps.encode(u.getPassword()));
    	 
    	 u.setRole("User");
    	 return us.save(u);
    }
    
    @Autowired
    private JwtUtil jwtUtil;

    public String login(String email, String password) {

        User user = us.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!ps.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user.getEmail(), user.getRole());
    }
	
}
