
package com.shopping.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(unique = true)
    
    @Email(regexp = "(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)", message = "must be a valid email address")
    private String email;

    
    @Column(length=100)
    @NotBlank(message = "must enter a password")
    @Size(min = 6, message = "Wrong password")
    private String password;
    
    @NotBlank(message = "must enter a valid address")
    private String address;
    
    @NotBlank(message = "must enter a valid city")
    private String city;
    
    @AssertTrue(message = "must accept terms and conditions")
    private boolean agreed;
    
    private String role;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonBackReference
    private List <Product> product;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonBackReference
    private List <OrderList> orderlist;

    public List<OrderList> getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(List<OrderList> orderlist) {
        this.orderlist = orderlist;
    }


    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isAgreed() {
        return agreed;
    }

    public void setAgreed(boolean agreed) {
        this.agreed = agreed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public User() {
    }

    public User(Long id, String email, String password, String address, String city, boolean agreed, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.address = address;
        this.city = city;
        this.agreed = agreed;
        this.role = role;
    }

    
}
