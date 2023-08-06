package com.emax.ecommercebackend.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginBodyRequest {
    private String username;
    private String password;
}
