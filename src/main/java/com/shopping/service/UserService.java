
package com.shopping.service;

import com.shopping.model.OrderList;
import com.shopping.model.Product;
import com.shopping.model.User;
import java.util.List;


public interface UserService {
    
    public void save(User user);
    
    public void save(OrderList orderlist);

//    public List<User> verify(String email, String password);
    
    public String enCryptedPassword(User user);
    
    public User findByEmail(String email);
    
    public void deleteProduct(long id);
    
    public List<OrderList> findByUserId(long id);
    
    
//    public void deleteProduct(long id);
//    
//    void saveProduct(Product product);
//    
//    List<Product> getProducts();
    
}
