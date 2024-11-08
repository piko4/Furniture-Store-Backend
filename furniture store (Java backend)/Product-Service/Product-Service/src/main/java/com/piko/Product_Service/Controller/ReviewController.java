package com.piko.Product_Service.Controller;

import com.piko.Product_Service.Model.Review;
import com.piko.Product_Service.Service.ProductService;
import com.piko.Product_Service.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    @Autowired
    ProductService productService;

    @GetMapping("getById/{id}")
    public ResponseEntity<Review>getById(@PathVariable Long id )
    {
        return ResponseEntity.ok(reviewService.fetchReviewById(id).get());
    }

    @GetMapping("getAllBy/productId/{productId}")
    public List<Review> getReviewsByProductId(@PathVariable Long productId) {

        return reviewService.fetchReviewsByProductId(productId);
    }

    @PostMapping("setBy/productId/{productId}")
    public ResponseEntity<String> setReviewByProductId(@PathVariable Long productId, @RequestBody Review review) {
        review.setProduct(productService.getProductById(productId));
        review.setDate(new Date());
        reviewService.saveReview(review);
        return ResponseEntity.ok("success");
    }

    @PostMapping("like/{id}")
    public ResponseEntity<String>addlike(@PathVariable Long id)
    {
        reviewService.savelikeById(id);
        return ResponseEntity.ok("Liked");
    }
    @PostMapping("dislike/{id}")
    public ResponseEntity<String>addDislike(@PathVariable Long id)
    {
        reviewService.savedislikeById(id);
        return ResponseEntity.ok("Disliked :(");
    }

}
