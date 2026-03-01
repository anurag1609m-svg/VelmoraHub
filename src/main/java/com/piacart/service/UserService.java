package com.piacart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.piacart.config.SecurityConfig;
import com.piacart.entity.User;
import com.piacart.repository.UserRepository;

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
	
}
