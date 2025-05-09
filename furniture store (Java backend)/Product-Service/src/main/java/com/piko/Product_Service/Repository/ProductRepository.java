package com.piko.Product_Service.Repository;

import com.piko.Product_Service.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByCategory(String category);

    List<Product> findAllByIdIn(List<Long> ids);

}
