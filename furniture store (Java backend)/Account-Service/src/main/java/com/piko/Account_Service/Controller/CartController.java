package com.piko.Account_Service.Controller;

import com.piko.Account_Service.Model.Cart;
import com.piko.Account_Service.Model.Wishlist;
import com.piko.Account_Service.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cart")
public class CartController {

    @Autowired
    CartService cartService;


    //    ---------------------add a product to cart---------------
    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestParam Long userId, @RequestParam Long productId) {
        Cart cart = cartService.addtoCart(userId, productId);
        return ResponseEntity.ok(cart);
    }

    //  ---------------------remove a product from cart---------------
    @PostMapping("/remove")
    public ResponseEntity<?> removeProduct(@RequestParam Long userId, @RequestParam Long productId) {
        Cart cart = cartService.removeFromCart(userId, productId);
        return ResponseEntity.ok(cart);
    }
}
