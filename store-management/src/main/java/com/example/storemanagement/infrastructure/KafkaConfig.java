package com.example.storemanagement.infrastructure;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(Source.class)
public class KafkaConfig {
    // This class will contain Kafka configuration details
}