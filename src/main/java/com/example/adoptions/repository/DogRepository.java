package com.example.adoptions.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.adoptions.model.Dog;

public interface DogRepository extends ListCrudRepository<Dog, Integer>{
    
}
