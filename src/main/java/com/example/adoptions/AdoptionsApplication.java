package com.example.adoptions;

import javax.sql.DataSource;

import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdoptionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdoptionsApplication.class, args);
	}

	@Bean
	PromptChatMemoryAdvisor promptChatMemoryAdvisor(DataSource dataSource) {

	var jdbc = JdbcChatMemoryRepository
			.builder()
			.dataSource(dataSource)
			.build();

	var chatMessageWindow = MessageWindowChatMemory
			.builder()
			.chatMemoryRepository((ChatMemoryRepository) jdbc)
			.build();

	return PromptChatMemoryAdvisor
			.builder(chatMessageWindow)
			.build();		
	}		
}

