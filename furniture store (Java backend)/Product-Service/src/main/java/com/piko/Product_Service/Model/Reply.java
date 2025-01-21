package com.piko.Product_Service.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String message;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;
}
