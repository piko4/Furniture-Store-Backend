package com.piko.Product_Service.Service;

import com.piko.Product_Service.Model.Review;
import com.piko.Product_Service.Repository.ReviewRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public List<Review> fetchReviewsByProductId(Long productId) {
        return reviewRepository.findAllByProduct_id(productId);
    }

    public void saveReview(Review review) {
        reviewRepository.save(review);
    }

    public Optional<Review> fetchReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public void savelikeById(Long id) {
         reviewRepository.addlikeByReviewId(id);

    }

    public void savedislikeById(Long id) {
    reviewRepository.findById(id).get().addDislike();
    }
}
