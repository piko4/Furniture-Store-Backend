package com.piko.Account_Service.Service;

import com.piko.Account_Service.Model.User;
import com.piko.Account_Service.Model.Wishlist;
import com.piko.Account_Service.Repository.UserRepository;
import com.piko.Account_Service.Repository.WishlistRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    //------------------------------------------add to wish
    @Transactional
    public Wishlist addProductToWishlist(Long userId, Long productId) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        Wishlist wishlist = user.getWishlist();
        if (wishlist == null) {
            wishlist = new Wishlist();
            user.setWishlist(wishlist);
        }
        if (!wishlist.getProductIds().contains(productId)) {
            wishlist.getProductIds().add(productId);
        }
        return wishlistRepository.save(wishlist);
    }

    //------------------------------------------------rmv product from wish
    @Transactional
    public Wishlist removeProductFromWishlist(Long userId, Long productId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null || user.getWishlist() == null) {
            throw new RuntimeException("User or wishlist not found");
        }
        Wishlist wishlist = user.getWishlist();
        wishlist.getProductIds().remove(productId);
        return wishlistRepository.save(wishlist);
    }
}
