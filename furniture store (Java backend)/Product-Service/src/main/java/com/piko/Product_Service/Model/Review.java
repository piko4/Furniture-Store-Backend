package com.piko.Product_Service.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String username;
    private String profileImageURL;
    private int rating;
    private String title;
    private String description;
    private Date date;

    private int like = 0;
    private int dislike = 0;

    public void addLike() {
        this.like++;
    }

    public void addDislike() {
        this.dislike++;
    }




    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore  // Prevents recursion
    private Product product;


    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<Reply> replies;

}
