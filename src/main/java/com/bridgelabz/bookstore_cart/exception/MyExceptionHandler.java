package com.bridgelabz.bookstore_cart.exception;

import com.bridgelabz.bookstore_cart.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class MyExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ResponseDTO> handleBookStoreException(Exception exception){
        ResponseDTO responseDTO = new ResponseDTO("ERROR => BookStoreException", exception.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
