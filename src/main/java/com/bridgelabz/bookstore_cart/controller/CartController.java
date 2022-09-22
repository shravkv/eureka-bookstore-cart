package com.bridgelabz.bookstore_cart.controller;

import com.bridgelabz.bookstore_cart.dto.CartDTO;
import com.bridgelabz.bookstore_cart.dto.ResponseDTO;
import com.bridgelabz.bookstore_cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")

public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/addtocart")
    public ResponseEntity<ResponseDTO> addToCart(@RequestHeader(name = "Authorization") String token, @RequestBody CartDTO cartDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Cart Added Successfully", cartService.addToCart(cartDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{cartId}")
    public ResponseEntity<ResponseDTO> updateCart(@RequestHeader(name = "Authorization") String token, @RequestBody CartDTO cartDTO, @PathVariable long cartId) {
        ResponseDTO responseDTO = new ResponseDTO("Cart Updated Successfully", cartService.UpdateCart(cartDTO, cartId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = {"/getall", "/"})
    public ResponseEntity<ResponseDTO> getAllCarts(@RequestHeader(name = "Authorization") String token) {
        ResponseDTO responseDTO = new ResponseDTO("Get call Successful", cartService.getAllCarts());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<ResponseDTO> getCartById(@RequestHeader(name = "Authorization") String token, @PathVariable Long cartId) {
        ResponseDTO responseDTO = new ResponseDTO("Get call Successful", cartService.getById(cartId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartId}")
    public ResponseEntity<ResponseDTO> deleteCartById(@RequestHeader(name = "Authorization") @PathVariable Long cartId) {
        ResponseDTO responseDTO = new ResponseDTO("Cart Deleted Successfully", cartService.deleteCartById(cartId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
