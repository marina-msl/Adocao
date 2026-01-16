package com.example.adoptions.controller;
import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.adoptions.repository.DogRepository;

@Controller
@ResponseBody
public class AdoptionsController {
    
    private final ChatClient ai;

    AdoptionsController(JdbcClient db,
                        PromptChatMemoryAdvisor promptAdvisor, 
                        ChatClient.Builder ai,
                        DogRepository repository,
                        VectorStore vectorStore) {

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
                        You are an AI powered assistant to help people adopt a dog from the 
                        adoption agency named Pooch Palace with locations in Rio de Janeiro, 
                        Mexico City, Seoul, Tokyo, Singapore, New York City, Amsterdam, Paris, 
                        Mumbai, New Delhi, Barcelona, London, and San Francisco. 
                        Information about the dogs available will be presented below. 
                        If there is no information, then return a polite response suggesting 
                        we don't have any dogs available.
                """;
        this.ai = ai
                .defaultAdvisors(
                        promptAdvisor,
                        QuestionAnswerAdvisor.builder(vectorStore).build())
                        .build();
    }

    @GetMapping("/{user}/assistant")
    String inquire(@PathVariable String user, @RequestParam String question) {
            return ai
                    .prompt()
                    .user(question)
                    .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, user))
                    .call()
                    .content();
    }
}