package com.bridgelabz.bookstore_cart.model;

import com.bridgelabz.bookstore_cart.dto.CartDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cart")
public class Cart {
    @Id
    private long cartId;
    private long userId;
    private long bookId;
    private long quantities;
    private double totalCartPrice;

    public Cart(CartDTO cartDTO) {
        this.cartId = cartDTO.getBookId();
        this.userId = cartDTO.getUserId();
        this.bookId = cartDTO.getBookId();
        this.quantities = cartDTO.getQuantity();
        this.totalCartPrice = cartDTO.getTotalCartPrice();
    }
}
