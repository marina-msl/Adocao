package com.example.adoptions.controller;
import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.adoptions.repository.DogRepository;
import com.example.adoptions.service.DogAdoptionsScheduler;

@RestController
public class AdoptionsController {
    
    private final ChatClient ai;

     AdoptionsController(JdbcClient db,
                         PromptChatMemoryAdvisor promptAdvisor, 
                         ChatClient.Builder ai,
                         DogRepository repository,
                         VectorStore vectorStore,
                         DogAdoptionsScheduler scheduler) {


         var count = db
                 .sql("select count(*) from vector_store")
                 .query(Integer.class)
                 .single();

         if (count == 0) {
                 repository.findAll().forEach(dog -> {
                         Document dogument = new Document("id: %s, name: %s, description: %s".formatted(
                                 dog.getId(), dog.getName(), dog.getDescription()
                         ));
                         vectorStore.add(List.of(dogument));
                 });
         }

        var system = """
                   Você é um assistente com inteligência artificial criado para ajudar pessoas a adotar 
                   um cachorro da agência de adoção chamada Pooch Palace, que possui unidades no 
                   Rio de Janeiro, Cidade do México, Seul, Tóquio, Singapura, Nova York, Amsterdã, Paris, 
                   Mumbai, Nova Délhi, Barcelona, Londres e São Francisco.
                   As informações sobre os cães disponíveis serão apresentadas abaixo.
                   Caso não haja informações, retorne uma resposta educada informando que não há 
                   cães disponíveis no momento.
                """;
        this.ai = ai
                 .defaultSystem(system)
                 .defaultTools(scheduler)
                 .defaultAdvisors(
                         promptAdvisor,
                        QuestionAnswerAdvisor.builder(vectorStore).build())
                 .build();
        }


        @GetMapping(value = "/{user}/assistant")
        String inquire(@PathVariable String user, @RequestParam String question) {
                
                long start = System.currentTimeMillis();
                System.out.println("Before LLM call");
                System.out.println("question: " + question);

                String response =  ai
                        .prompt()
                        .user(question)
                        .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, user))
                        .call()
                        .content();

                        long end = System.currentTimeMillis();
                        System.out.println("CONVERSTION ID: " + user);
                        System.out.println("Response time: " + (end - start) + " ms");

                        return response;
        }
}
 
