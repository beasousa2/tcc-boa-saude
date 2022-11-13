package br.com.boasaude.microserviceassociado.adapters.kafka.config;


import lombok.AllArgsConstructor;
import org.apache.avro.generic.GenericRecord;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;

@EnableKafka
@Configuration
@AllArgsConstructor
public class KafkaConfig {

    private KafkaProperties kafkaProperties;

    @Bean
    public ConsumerFactory<String, GenericRecord> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, GenericRecord>>
        kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, GenericRecord> listener =
                new ConcurrentKafkaListenerContainerFactory<>();
        listener.setConsumerFactory(consumerFactory());

        listener.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);

        listener.getContainerProperties().setSyncCommits(Boolean.TRUE);

        return listener;
    }
}
