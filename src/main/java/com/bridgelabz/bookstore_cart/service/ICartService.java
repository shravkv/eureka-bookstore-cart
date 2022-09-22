package com.bridgelabz.bookstore_cart.service;

import com.bridgelabz.bookstore_cart.dto.CartDTO;
import com.bridgelabz.bookstore_cart.model.Cart;

import java.util.List;
import java.util.Optional;

public interface ICartService {
    Cart addToCart(CartDTO cartDTO);
    List<Cart> getAllCarts();

    Optional<Cart> getById(long id);

    String deleteCartById(long id);

    Cart UpdateCart(CartDTO cartDTO, long cartId);
}
