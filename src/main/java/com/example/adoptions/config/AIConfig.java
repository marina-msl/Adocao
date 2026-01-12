package com.example.adoptions.config;

import javax.sql.DataSource;

import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfig {

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
