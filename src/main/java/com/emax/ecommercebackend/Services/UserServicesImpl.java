package com.emax.ecommercebackend.Services;

import com.emax.ecommercebackend.Exception.UserAlreadyExistException;
import com.emax.ecommercebackend.Services.encryptionsService.EncryptionService;
import com.emax.ecommercebackend.Services.encryptionsService.JWTService;
import com.emax.ecommercebackend.api.model.LoginBodyRequest;
import com.emax.ecommercebackend.api.model.RegistrationBodyRequest;
import com.emax.ecommercebackend.data.model.LocalUser;
import com.emax.ecommercebackend.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EncryptionService encryptionService;
    @Autowired
    private JWTService jwtService;

    @Override
    public LocalUser registerUser( RegistrationBodyRequest registrationBodyRequest) {
        if(userRepository.findByUsernameIgnoreCase(registrationBodyRequest.getUsername()).isPresent()
                || userRepository.findByEmailIgnoreCase(registrationBodyRequest.getEmail()).isPresent()){
            throw new UserAlreadyExistException("this required field already exist");
        }

        LocalUser user = new LocalUser();
        user.setFirstName(registrationBodyRequest.getFirstName());
        user.setLastName(registrationBodyRequest.getLastName());
        user.setUsername(registrationBodyRequest.getUsername());
        user.setEmail(registrationBodyRequest.getEmail());
        user.setPassword(encryptionService.encryptedPassword(registrationBodyRequest.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public String loginUser(LoginBodyRequest loginBodyRequest) {
        Optional<LocalUser> userOptional = userRepository.findByUsernameIgnoreCase(loginBodyRequest.getUsername());
        if(userOptional.isPresent()){
            LocalUser foundUser = userOptional.get();
            if(encryptionService.verifyPassword(loginBodyRequest.getPassword(), foundUser.getPassword())){
                return jwtService.generateJWT(foundUser);
            }

        }

    return null;
    }


}
