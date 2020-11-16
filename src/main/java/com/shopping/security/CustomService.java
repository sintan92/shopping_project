
package com.shopping.security;

import com.shopping.model.User;
import com.shopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomService implements UserDetailsService{

    @Autowired
    UserRepository repository;
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User user = repository.findByEmail(username);
        
        if(user == null){
            throw new UsernameNotFoundException("user not found!");
        }
        
        CustomUserDetails customUser = new CustomUserDetails(user);
        
        return customUser;
        
    }
    }
   
