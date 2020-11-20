//
//package com.shopping.controller;
//
//import com.shopping.model.Product;
//import com.shopping.service.UserService;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class RestProductController {
//    
//    @Autowired
//    private UserService serv;
//    
//    @GetMapping("/product/delete/{id}")
//    public String deleteMovie(@PathVariable int id) {
//        serv.deleteProduct(id);
//        return "redirect:/";
//    }
//    
//    @PostMapping("/products")
//    public void saveProducts(@RequestBody Product p){
//       serv.saveProduct(p);
//    }
//    
//    @GetMapping("products")
//    public List<Product> getProducts(){
//    return serv.getProducts();
//    }
//    
//}
