package com.piko.Account_Service.Repository;

import com.piko.Account_Service.Model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist,Long> {

}
