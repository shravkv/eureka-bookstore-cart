package com.bridgelabz.bookstore_cart.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class CartDTO {
    long userId;
    double totalCartPrice;
    long bookId;
    long quantity;
}
