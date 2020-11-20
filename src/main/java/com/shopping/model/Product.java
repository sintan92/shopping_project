
package com.shopping.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.OneToMany;

@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int price;
    private String description;
    private String photo;


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private User user;

    public Product(String name, int price, String description, String photo) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.photo = photo;
    }
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    @JsonManagedReference
    private List<OrderList> orderlist;

    public List<OrderList> getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(List<OrderList> orderlist) {
        this.orderlist = orderlist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + ", photo=" + photo + ", user=" + user + ", orderlist=" + orderlist + '}';
    }


}
