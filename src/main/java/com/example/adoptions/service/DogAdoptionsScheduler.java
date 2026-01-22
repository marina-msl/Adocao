package com.example.adoptions.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class DogAdoptionsScheduler {


    @Tool(description = " Agende um horário para pegar ou adotar o cachorro" +
            " da agencia de adoção Pooch Palace")
    String schedule(Integer dogId, String dogName) {
        System.out.println("Scheduling adoption for dog ID: " + dogId + ", Name: " + dogName);

        return Instant
                    .now()
                    .plus(3, ChronoUnit.DAYS)
                    .toString();
    }
}