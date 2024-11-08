package com.piko.Product_Service.Repository;

import com.piko.Product_Service.Model.Review;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findAllByProduct_id(Long productId);

    @Modifying
    @Transactional
    @Query(value ="UPDATE review SET \"like\" = \"like\" + 1 WHERE id = :id" ,nativeQuery = true)
    void addlikeByReviewId(@Param("id") Long id);
}
