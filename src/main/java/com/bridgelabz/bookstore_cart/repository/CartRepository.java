package com.bridgelabz.bookstore_cart.repository;

import com.bridgelabz.bookstore_cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
}
