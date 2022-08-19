package br.com.boasaude.associado.apirest.adapters.kafka.producers;

import br.com.boasaude.associado.apirest.adapters.kafka.producers.header.KafkaHeader;
import br.com.boasaude.associado.apirest.dto.KafkaHeaderDto;
import br.com.boasaude.associado.criar_associado_novo_realizada.CriaAssociadoNovoRealizada;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CriarAssociadoProducer {

    @Value("${spring.kafka.producer.criar.topic}")
    private String topic;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaHeader kafkaHeader;

    public void producerSuccess(CriaAssociadoNovoRealizada avro, KafkaHeaderDto kafkaHeaderDto) {

        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(
                topic,
                null,
                kafkaHeaderDto.getTransactionId(),
                avro,
                kafkaHeader.getHeaders(kafkaHeaderDto)
        );

        kafkaTemplate.send(producerRecord);

    }

    public void producerError(KafkaHeaderDto kafkaHeaderDto) {
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(
                topic,
                null,
                kafkaHeaderDto.getTransactionId(),
                null,
                kafkaHeader.getHeaders(kafkaHeaderDto)
        );

        kafkaTemplate.send(producerRecord);
    }
}
