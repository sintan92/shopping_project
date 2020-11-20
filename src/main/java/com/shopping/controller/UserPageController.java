
package com.shopping.controller;

import com.shopping.model.OrderList;
import com.shopping.model.Product;
import com.shopping.model.User;
import com.shopping.repository.OrderListRepository;
import com.shopping.repository.ProductRepository;
import com.shopping.repository.UserRepository;
import com.shopping.service.UserService;
import java.security.Principal;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserPageController {
    
    
    @Autowired
    private ProductRepository prod;
    
    @Autowired
    private OrderListRepository order;
    
    @Autowired
    private UserRepository use;
    
    @Autowired
    private UserService userserv;
    
    @GetMapping("/product")
    public String showProductPage(Model model){
 
        model.addAttribute("products", prod.findAll());
        
        return "/user/product";
    }
    
    @GetMapping("/shoppingcart")
    public String showShoppingCartPage(Model model, Principal p){
        
        User user = userserv.findByEmail(p.getName());

        model.addAttribute("orders", order.findByUserId(user.getId()));
//        model.addAttribute("orders", order.findAll());
        
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
              
//              user.getProduct();
//              List<Product> products = (List<Product>) prod.findAll();
//              System.out.println(products);
//              System.out.println(id);
              
              Product product = prod.findById(id).get();
//              System.out.println("this is product one" + product1);
          
//            user.getProduct().add(product);
//            product.setUser(user);
                orderProduct.setUser(user);
//             prod.save(product);
            orderProduct.setName(product.getName());
            orderProduct.setPrice(product.getPrice());
//           user.getOrderlist().add(order1);
           
            userserv.save(orderProduct);

     

        return "redirect:/user/product";
    }
    
    
    
//    @GetMapping("/user/product/{id}")
//    public String AddToCart(@PathVariable("id") Long productId) {
//
//        System.out.println("this is where id will show up" + productId);
//        
////         User user = userserv.findByEmail(principal.getName());
//         
//         Long l= new Long(productId);
//         int i=l.intValue();
//
////         Product product = orderlist.getProduct().get(i);
//      
//       
//        
////        Product product = new Product();
////        String productName = product.getName();
////        int productPrice = product.getPrice();
//        
//        
////      OrderList order_list = new OrderList(productName, productPrice);
//        
//
////            userserv.save(order_list);
//
//            return "redirect:/user/product";
//    
//}
}