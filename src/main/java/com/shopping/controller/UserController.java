
package com.shopping.controller;

import com.shopping.model.User;
import com.shopping.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    
    @Autowired
    private UserService serv;
    
    
    @GetMapping("/")
    public String showLoginPage(Model model) {

    model.addAttribute("user", new User());

        return "login";

    }

    @GetMapping("/registration")
    public String Register(Model model) {

        model.addAttribute("user", new User());

        return "registration";

    }
    
        @PostMapping("logged")
    public String ShowLoggedPage(/*@Valid*/ @ModelAttribute User login, BindingResult result) {
        
       
        List <User> list = serv.verify(login.getEmail(), login.getPassword());
        
        if (list.isEmpty()) {

            return "login";
        } else {
            return "product";
        }
        
//         String verify = list.isEmpty()?"login":"success";
//        return verify;
    
    }
    
    @PostMapping("process")
    public String ShowSuccessPage(/*@Valid*/ @ModelAttribute User login, BindingResult result) {

//        login.setRole("ROLE_USER");
//        
//        login.setPassword(serv.encryptPassword(login.getPassword()));
        
      
        if (result.hasErrors()) {
            
            return "registration";
        } else {

            serv.save(login);

        }
        {
            return "login";
        }

    }
    
    
    
}
