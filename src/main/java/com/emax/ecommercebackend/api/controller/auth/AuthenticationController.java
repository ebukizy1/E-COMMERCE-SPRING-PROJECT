package com.emax.ecommercebackend.api.controller.auth;

import com.emax.ecommercebackend.Exception.UserAlreadyExistException;
import com.emax.ecommercebackend.Services.UserServices;
import com.emax.ecommercebackend.api.model.LoginBodyRequest;
import com.emax.ecommercebackend.api.model.LoginResponse;
import com.emax.ecommercebackend.api.model.LoginUserDetailsResponse;
import com.emax.ecommercebackend.api.model.RegistrationBodyRequest;
import com.emax.ecommercebackend.data.model.LocalUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserServices userServices;

    @PostMapping("register")
    public ResponseEntity RegisterUser(@Valid @RequestBody RegistrationBodyRequest registrationBodyRequest){
        try {
            userServices.registerUser(registrationBodyRequest);
            return ResponseEntity.ok().build();
        }catch (UserAlreadyExistException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginBodyRequest loginBodyRequest) {

        String jwt = userServices.loginUser(loginBodyRequest);
        if (jwt == null) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            LoginResponse response = new LoginResponse();
            response.setJwtToken(jwt);
            return ResponseEntity.ok(response);
        }
    }



    @GetMapping("me")
    public ResponseEntity<LoginUserDetailsResponse> getLoggedInUserProfile(@AuthenticationPrincipal LocalUser user){
        LocalUser foundUser = user;
        LoginUserDetailsResponse detailsResponse = new LoginUserDetailsResponse();
        detailsResponse.setID(foundUser.getId());
        detailsResponse.setUsername(foundUser.getUsername());
        detailsResponse.setEmail(foundUser.getEmail());
        detailsResponse.setFirstName(foundUser.getFirstName());
        detailsResponse.setLastName(foundUser.getLastName());
        return  ResponseEntity.ok(detailsResponse);
    }
}
