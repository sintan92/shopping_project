
package com.shopping.service;

import com.shopping.model.User;
import com.shopping.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
   private UserRepository repo;
    
    
    @Override
    public void save(User login) {
        repo.save(login);
    }

    @Override
    public List<User> verify(String email, String password) {
        
        return repo.findByEmailAndPassword(email, password);
    }
    
}
