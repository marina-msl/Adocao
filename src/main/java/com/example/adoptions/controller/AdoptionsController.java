package com.example.adoptions.controller;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class AdoptionsController {
    
    private final ChatClient ai;

    AdoptionsController(PromptChatMemoryAdvisor advisor, ChatClient.Builder ai) {
        var system = """
                Você é um assistente inteligente da Pooch Palace, uma agência de adoção 
                de cães com unidades no Rio de Janeiro, Cidade do México, Seul, 
                Tóquio, Singapura, Nova York, Amsterdã, Paris, Mumbai, Nova Délhi, 
                Barcelona, Londres e São Francisco. 
                Seu objetivo é ajudar as pessoas a encontrar o cachorro perfeito para adoção. 
                As informações sobre os cães disponíveis serão fornecidas a seguir. 
                Caso não haja cães disponíveis, responda de forma educada informando que no 
                momento não temos cachorros para adoção.
                """;
        this.ai = ai
                    .defaultAdvisors(advisor)             .build();
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