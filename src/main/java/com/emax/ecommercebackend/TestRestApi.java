package com.emax.ecommercebackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestApi {

    @GetMapping("/test")
    public String testMapping(){
        return "test";
    }
}
