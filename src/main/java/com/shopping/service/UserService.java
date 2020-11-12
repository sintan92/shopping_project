
package com.shopping.service;

import com.shopping.model.User;
import java.util.List;


public interface UserService {
    
    public void save(User login);

    public List<User> verify(String email, String password);
    
}
