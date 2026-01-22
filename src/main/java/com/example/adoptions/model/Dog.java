package com.example.adoptions.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Dog {

    @Id
    private int id;
    private String name;
    private String description;
    
}
