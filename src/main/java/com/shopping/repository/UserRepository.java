
package com.shopping.repository;

import com.shopping.model.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    
    
    public List<User> findByEmailAndPassword(String email, String password);
}
