package com.example.ridermanagement.infrastructure.messaging;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(Source.class)
public class KafkaProducerConfig {
    // Configuration for Kafka producer will be here
}