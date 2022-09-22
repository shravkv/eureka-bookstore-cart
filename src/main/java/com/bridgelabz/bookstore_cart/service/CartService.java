package com.bridgelabz.bookstore_cart.service;

import com.bridgelabz.bookstore_cart.dto.CartDTO;
import com.bridgelabz.bookstore_cart.exception.CustomException;
import com.bridgelabz.bookstore_cart.model.Cart;
import com.bridgelabz.bookstore_cart.repository.CartRepository;
import com.bridgelabz.bookstore_cart.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bridgelabz.bookstore_cart.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Cart addToCart(CartDTO cartDTO) {
        User user = restTemplate.getForObject("http://localhost:8081/user/id/"+cartDTO.getUserId(), User.class);
        Book book= restTemplate.getForObject("http://localhost:8082/book/id/"+cartDTO.getBookId(), Book.class);
        System.out.println(user.getFirstName());
        System.out.println(book.getBookName());
        if (user.equals(null) || book.equals(null)) {
            throw new CustomException("User or Book Id is invalid! please check and try again!");
        } else {
            Cart cart = new Cart(cartDTO);
            cartRepository.save(cart);
            return cart;
        }
    }
    @Override
    public List<Cart> getAllCarts() {
        List<Cart> cartList=cartRepository.findAll();
        return cartList;
    }
    @Override
    public Optional<Cart> getById(long id) {
        Optional<Cart> cart=cartRepository.findById(id);
        if (cart.isPresent()){
            return cart;
        }else {
            throw new CustomException("Sorry! We can not find the cart id: "+id);
        }
    }
    @Override
    public String deleteCartById(long id) {
        Optional<Cart> cart=cartRepository.findById(id);
        if (cart.isPresent()){
            cartRepository.deleteById(id);
            return "Cart deleted";
        }else {
            throw new CustomException("Sorry! We can not find cart id: "+id);
        }
    }
    @Override
    public Cart UpdateCart(CartDTO cartDTO, long cartId) {
        Cart cart = cartRepository.findById(cartId).get();
        if (cartRepository.findById(cartId).isPresent()) {
                cart.setUserId(cartDTO.getUserId());
                cart.setBookId(cartDTO.getBookId());
                cart.setQuantities(cartDTO.getQuantity());
                cartRepository.save(cart);
                return cart;
        } else {
            throw new CustomException("Your details are incorrect! Please check!");
        }
    }
}

