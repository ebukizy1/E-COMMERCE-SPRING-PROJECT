package com.emax.ecommercebackend.api.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RegistrationBodyRequest {

 @NotNull
 @NotBlank
@Size(min = 5 , max = 35)
private String username;

@Email
@NotNull
@NotBlank
private String email;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d).{8,}$")
    @Size(min = 5 , max = 35)
private String password;

    @NotNull
    @NotBlank
private String firstName;

    @NotNull
    @NotBlank
private String lastName;

}
