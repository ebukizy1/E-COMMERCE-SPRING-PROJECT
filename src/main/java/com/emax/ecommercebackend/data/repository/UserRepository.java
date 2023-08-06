package com.emax.ecommercebackend.data.repository;

import com.emax.ecommercebackend.data.model.LocalUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<LocalUser , Long> {
    Optional<LocalUser> findByUsernameIgnoreCase(String username);
    Optional<LocalUser> findByEmailIgnoreCase(String email);



}
