package com.example.adoptions.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class DogAdoptionCompability {

      @Tool(description = "Verifique se o cachorro é compatível com criança, outros pets ou cachorros,"
                    + "ou para viver em apartamento")
    String checkCompatibility(String dogName, String situation) {
        System.out.println("Verificando a compatibilidade de " + dogName + " com " + situation);
        
        if (situation.toLowerCase().contains("children")) {
            return dogName + " eh otimo com criança e muito amigável";
        } else if (situation.toLowerCase().contains("apartment")) {
            return dogName + " adapta bem a viver em apartamento com caminhadas diárias.";
        } else if (situation.toLowerCase().contains("cats") || situation.toLowerCase().contains("pets")) {
            return dogName + " foi socilizado com outros cachorros.";
        }
        return dogName + " eh compativel com a sua situação.";
    }

}
