
package com.shopping.controller;

import com.shopping.model.OrderList;
import com.shopping.model.Product;
import com.shopping.model.User;
import com.shopping.repository.OrderListRepository;
import com.shopping.repository.ProductRepository;
import com.shopping.service.UserService;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserPageController {
    
    public List<Product> allProducts;

    @Autowired
    private ProductRepository prod;
    
    @Autowired
    private OrderListRepository order;
    
    @Autowired
    private UserService userserv;
    
    public static boolean isNullOrEmpty(String str) {
        
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }
    
    @GetMapping("/product")
    public String showProductPage(Model model, String name){
        
        if(isNullOrEmpty(name)){
            model.addAttribute("products", prod.findAll());
        }else{
         List<Product> product = prod.findbynamehaving(name);
         allProducts = product;
         model.addAttribute("products", allProducts);
        }
        return "/user/product";
    }
    
    @GetMapping("/shoppingcart")
    public String showShoppingCartPage(Model model, Principal p){
        
        User user = userserv.findByEmail(p.getName());
        model.addAttribute("orders", order.findByUserId(user.getId()));        
        return "/user/shoppingcart";
    }
    
    @GetMapping("/product/delete/{id}")
    public String deleteProductFromCart(@PathVariable("id") Long id, Model model) {
        
        userserv.deleteProduct(id);
        return "redirect:/user/shoppingcart";
    }
    
         @GetMapping("/process-product/{id}")
    public String postContact(@PathVariable("id") Long id, Model model, Principal p) {

            
            User user = userserv.findByEmail(p.getName());
            OrderList orderProduct =new OrderList();

            Product product = prod.findById(id).get();
            orderProduct.setUser(user);

            orderProduct.setName(product.getName());
            orderProduct.setPrice(product.getPrice());
            orderProduct.setUsermail(user.getEmail());
            userserv.save(orderProduct);

        return "redirect:/user/product";
    }
    
    @GetMapping("checkout")
    public String checkout() {
        
        return "/user/checkout";
    }

}