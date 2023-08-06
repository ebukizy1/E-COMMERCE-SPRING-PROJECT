package com.emax.ecommercebackend.Exception;

public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException(String message){
        super(message);
    }
}
