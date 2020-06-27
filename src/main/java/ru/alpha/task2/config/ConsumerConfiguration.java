package ru.alpha.task2.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import ru.alpha.task2.model.PaymentsDto;

import java.util.HashMap;
import java.util.Map;

@Configuration
//@EnableKafka
public class ConsumerConfiguration {

    @Value("${spring.kafka.bootstrap-servers}")
    private String server;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PaymentsDto> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, PaymentsDto> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, PaymentsDto> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfig(), new StringDeserializer(), new JsonDeserializer<>(PaymentsDto.class));
    }

    @Bean
    public Map<String, Object> consumerConfig() {
        Map<String, Object> properties = new HashMap<>();

        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, server);
        properties.put(ConsumerConfig.CLIENT_ID_CONFIG, "consumer-group");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "1");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
        properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return properties;
    }

}