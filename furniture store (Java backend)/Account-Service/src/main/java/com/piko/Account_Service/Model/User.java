package com.piko.Account_Service.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String email;
    private String password;
    private String address;

    //------------------------------cart--------------------------
    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    //----------------------------wish list--------------------
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wishlist_id")
    private Wishlist wishlist; //--favorite


    // Getters and setters...
    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    //---------------------------order----------------------
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

}
