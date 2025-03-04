package com.piko.Account_Service.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Store product IDs as a collection of Long values
    @ElementCollection
    @CollectionTable(name = "wishlist_products", joinColumns = @JoinColumn(name = "wishlist_id"))
    @Column(name = "product_id")
    private List<Long> productIds = new ArrayList<>();



    // Getters and setters
    public Long getId() {
        return id;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }
}
