package br.com.boasaude.microserviceassociado.adapters.kafka.producers;


import br.com.boasaude.associado.criar_associado_resposta.CriarAssociadoResposta;
import br.com.boasaude.microserviceassociado.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microserviceassociado.adapters.kafka.header.KafkaHeaderDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CriarNovoAssociadoProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaHeader kafkaHeader;
    @Value("${spring.kafka.producer.criar.topic}")
    private String topico;

    public void producerSuccess(CriarAssociadoResposta avro, KafkaHeaderDto kafkaHeaderDto) {

        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(
                topico,
                null,
                kafkaHeaderDto.getTransactionId(),
                avro,
                kafkaHeader.getHeaders(kafkaHeaderDto)
        );

        kafkaTemplate.send(producerRecord);

    }

    public void producerError(KafkaHeaderDto kafkaHeaderDto) {

        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(
                topico,
                null,
                kafkaHeaderDto.getTransactionId(),
                null,
                kafkaHeader.getHeaders(kafkaHeaderDto)
        );

        kafkaTemplate.send(producerRecord);

    }
}
