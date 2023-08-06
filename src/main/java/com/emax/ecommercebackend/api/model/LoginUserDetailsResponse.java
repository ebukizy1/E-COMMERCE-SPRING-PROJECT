package com.emax.ecommercebackend.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUserDetailsResponse {
    private Long ID;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
}
