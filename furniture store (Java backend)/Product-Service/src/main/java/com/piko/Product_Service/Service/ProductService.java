package com.piko.Product_Service.Service;

import com.piko.Product_Service.Model.Product;
import com.piko.Product_Service.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


//-----------------------
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
//---------------------
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found !!"));
    }
//-----------------
    public String setProduct(Product product) {
        productRepository.save(product);
        return "product created";
    }
//----------------------
    public List<Product> getAllByCategory(String category) {
        return productRepository.findAllByCategory(category);
    }

//---------------------
    public List<Product> getProductsByIds(List<Long> ids) {
        return productRepository.findAllByIdIn(ids);
    }

}
