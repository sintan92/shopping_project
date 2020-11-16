
package com.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserPageController {
    
    @GetMapping("/product")
    public String showProductPage(){
        
        
        return "/user/product";
    }
    
    @GetMapping("/shoppingcart")
    public String showShoppingCartPage(){
        
        
        return "/user/shoppingcart";
    }
    
}