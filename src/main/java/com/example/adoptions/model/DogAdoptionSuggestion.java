package com.example.adoptions.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DogAdoptionSuggestion {

     
    private int id;
    private String name;
    private String description;
}
