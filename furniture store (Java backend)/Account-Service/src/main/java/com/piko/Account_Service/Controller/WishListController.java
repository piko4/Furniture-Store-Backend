package com.piko.Account_Service.Controller;

import com.piko.Account_Service.Model.Wishlist;
import com.piko.Account_Service.Service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/wishlist")
public class WishListController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestParam Long userId, @RequestParam Long productId) {
        Wishlist wishlist = wishlistService.addProductToWishlist(userId, productId);

        return ResponseEntity.ok(wishlist);
    }

    @PostMapping("/remove")
    public ResponseEntity<?> removeProduct(@RequestParam Long userId, @RequestParam Long productId) {
        Wishlist wishlist = wishlistService.removeProductFromWishlist(userId, productId);
        return ResponseEntity.ok(wishlist);
    }
}
