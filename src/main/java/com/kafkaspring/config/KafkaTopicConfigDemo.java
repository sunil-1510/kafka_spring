package com.kafkaspring.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfigDemo {
	
	
	@Value("${spring.kafka.bootstrapAddress}")
	String bootstrapAddress;
	
	@Value("${kafka.custom.myTopic}")
	String TOPIC;
	
	@Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        System.out.println("Bootstrap Address is in admin config is   >>>"+bootstrapAddress);
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapAddress);
        return new KafkaAdmin(configs);
    }
    
	
	
	
	  @Bean public NewTopic topic1() {
	  
	  return new NewTopic(TOPIC, 1, (short)1);
	  
	  }
	 
	 
	 
}
