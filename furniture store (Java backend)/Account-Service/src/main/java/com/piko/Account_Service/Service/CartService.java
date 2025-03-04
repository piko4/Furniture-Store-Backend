package com.piko.Account_Service.Service;

import com.piko.Account_Service.Model.Cart;
import com.piko.Account_Service.Model.User;
import com.piko.Account_Service.Repository.CartRepository;
import com.piko.Account_Service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;


    //    ---------------------add a product to cart---------------
    public Cart addtoCart(Long userId, Long productId) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        Cart cart = user.getCart();
        if (cart == null) {
            cart = new Cart();
            user.setCart(cart);
        }
        if (!cart.getProductIds().contains(productId)) {
            cart.getProductIds().add(productId);
        }
        return cartRepository.save(cart);
    }


    //----------------remove product from cart----------------
    public Cart removeFromCart(Long userId, Long productId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null || user.getCart() == null) {
            throw new RuntimeException("User or wishlist not found");
        }
        Cart cart = user.getCart();
        cart.getProductIds().remove(productId);
        return cartRepository.save(cart);
    }
}
