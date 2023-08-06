package com.emax.ecommercebackend;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TestDataBaseObject {
    @Id
    private long id;
    @Column
    private String username;
}
