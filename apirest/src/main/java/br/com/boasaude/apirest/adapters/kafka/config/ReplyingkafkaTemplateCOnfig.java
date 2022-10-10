package br.com.boasaude.apirest.adapters.kafka.config;

import br.com.boasaude.associado.criar_associado.CriarAssociado;
import br.com.boasaude.associado.criar_associado_resposta.CriarAssociadoResposta;
import lombok.RequiredArgsConstructor;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.stereotype.Component;

@EnableKafka
@Component
@RequiredArgsConstructor
public class ReplyingkafkaTemplateCOnfig {

    private final KafkaProperties kafkaProperties;

    @Value("${spring.kafka.consumer.criar.topic}")
    private String topic;

    @Bean
    public ConsumerFactory<String, CriarAssociadoResposta> consumerFactoryAssociado() {
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
    }

    @Bean
    public ProducerFactory<String, CriarAssociado> producerFactory() {
        return new DefaultKafkaProducerFactory<>(kafkaProperties.buildAdminProperties());
    }

    @Bean
    public KafkaTemplate<String, CriarAssociado> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public KafkaMessageListenerContainer<String, CriarAssociadoResposta> replyContainer(
            ) {
        ContainerProperties containerProperties = new ContainerProperties(topic);
        return new KafkaMessageListenerContainer<>(consumerFactoryAssociado(), containerProperties);
    }

    @Bean
    public ReplyingKafkaTemplate<String, CriarAssociado, CriarAssociadoResposta> replyingKafkaTemplate(

    ) {
        return new ReplyingKafkaTemplate<>(producerFactory(), replyContainer());
    }
}
