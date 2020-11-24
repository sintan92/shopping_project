package com.shopping.controller;

import com.shopping.model.Product;
import com.shopping.model.User;
import com.shopping.repository.OrderListRepository;
import com.shopping.repository.ProductRepository;
import com.shopping.service.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductRepository prod;

    @Autowired
    private OrderListRepository order;

    @Autowired
    private UserService userserv;

    @GetMapping("/admin_products")
    public String showAdminProductPage(Model model) {

        model.addAttribute("admin_product", prod.findAll());
        return "/admin/admin_products";
    }

    @GetMapping("/product/deletebyadmin/{id}")
    public String deleteProductAdmin(@PathVariable("id") Long id, Model model) {
        userserv.deleteProductAdmin(id);
        return "redirect:/admin/admin_products";
    }

    @GetMapping("/add_products")
    public String showAddProductsPage(Model model) {

        return "/admin/add_products";

    }

    @GetMapping("/orders")
    public String showOrdersPage(Model model) {

        model.addAttribute("findorders", order.findAll());
        return "/admin/orders";

    }

    @GetMapping("/addproduct")
    public String AddProducts(Model model, Product product, Principal p) {

        User user = userserv.findByEmail(p.getName());
        product.setUser(user);

        model.addAttribute("title", prod.save(product));
        return "/admin/add_products";

    }

    @GetMapping("/product/delete/{id}")
    public String OrderDone(@PathVariable("id") Long id, Model model) {

        userserv.deleteProduct(id);
        return "redirect:/admin/orders";
    }
}
