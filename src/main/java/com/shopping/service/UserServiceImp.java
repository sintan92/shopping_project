
package com.shopping.service;

import com.shopping.model.OrderList;
import com.shopping.model.Product;
import com.shopping.model.User;
import com.shopping.repository.OrderListRepository;
//import com.shopping.repository.ProductRepository;
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
//    private ProductRepository prod;
    
    @Autowired
   private OrderListRepository order;
    
    
    @Override
    public void save(User user) {
        use.save(user);
    }

//    @Override
//    public List<User> verify(String email, String password) {
//        
//        return repo.findByEmailAndPassword(email, password);
//    }

    @Override
    public String enCryptedPassword(User user) {
        return  encrypt.encode(user.getPassword());
    }

//    @Override
//    public void deleteProduct(long id) {
//       prod.deleteById(id);
//    }
//
//    @Override
//    public void saveProduct(Product product) {
//       prod.save(product);
//    }
//
//    @Override
//    public List<Product> getProducts() {
//     return (List<Product>) prod.findAll();
//    }

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

   




}
