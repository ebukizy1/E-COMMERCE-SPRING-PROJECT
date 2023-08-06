package com.emax.ecommercebackend.Services;

import com.emax.ecommercebackend.api.model.LoginBodyRequest;
import com.emax.ecommercebackend.api.model.RegistrationBodyRequest;
import com.emax.ecommercebackend.data.model.LocalUser;

public interface UserServices {

    LocalUser registerUser(RegistrationBodyRequest registrationBodyRequest);
    String loginUser(LoginBodyRequest loginBodyRequest);

}
