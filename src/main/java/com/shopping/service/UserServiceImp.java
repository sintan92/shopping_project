
package com.shopping.service;

import com.shopping.model.OrderList;
import com.shopping.model.Product;
import com.shopping.model.User;
import com.shopping.repository.OrderListRepository;
import com.shopping.repository.ProductRepository;
import com.shopping.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private BCryptPasswordEncoder encrypt;
    
    @Autowired
   private UserRepository use;
    
    @Autowired
   private OrderListRepository order;
    
     @Autowired
   private ProductRepository prod;
    
    
    @Override
    public void save(User user) {
        use.save(user);
    }

    @Override
    public String enCryptedPassword(User user) {
        return  encrypt.encode(user.getPassword());
    }

    @Override
    public void save(OrderList orderlist) {
       order.save(orderlist);
    }

    @Override
    public User findByEmail(String email) {
      return use.findByEmail(email);
    }

    @Override
    public void deleteProduct(long id) {
        order.deleteById(id);
    }

    @Override
    public List<OrderList> findByUserId(long id) {
       return order.findByUserId(id);
    }

    @Override
    public void deleteProductAdmin(long id) {
        prod.deleteById(id);
    }

    @Override
    public List<Product> findbynamehaving(String name) {
       return prod.findbynamehaving(name);
    }

}
