package com.piko.Product_Service.Service;

import com.piko.Product_Service.Model.Product;
import com.piko.Product_Service.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
         return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found !!"));
    }

    public String setProduct(Product product) {
        productRepository.save(product);
        return "product created";
    }
}
