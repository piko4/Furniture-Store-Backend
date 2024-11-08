package com.piko.Product_Service.Controller;

import com.piko.Product_Service.Model.Product;
import com.piko.Product_Service.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    //    -------------- * * * Fetch All Products * * * --------------

    @GetMapping("getAll")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //    -------------- * * * Fetch All Products By Category * * * --------------
    @GetMapping("getAllByCategory/{category}")
    public List<Product> getAllProductsByCategory(@PathVariable String category) {
        return productService.getAllByCategory(category);
    }

    //    -------------- * * * Fetch a Product By Id * * * --------------
    @GetMapping("getById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    //    -------------- * * * for creating new Product * * * --------------
    @PostMapping("create")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.setProduct(product));

    }
}
