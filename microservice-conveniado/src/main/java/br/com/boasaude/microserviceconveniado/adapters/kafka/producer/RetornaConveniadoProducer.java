package br.com.boasaude.microserviceconveniado.adapters.kafka.producer;

import br.com.boasaude.microserviceconveniado.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microserviceconveniado.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceconveniado.retorno_conveniado.RetornoConveniado;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RetornaConveniadoProducer {


    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaHeader kafkaHeader;

    public void producerSuccess(RetornoConveniado avro, KafkaHeaderDto kafkaHeaderDto, String topic) {

        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(
                topic,
                null,
                kafkaHeaderDto.getTransactionId(),
                avro,
                kafkaHeader.getHeaders(kafkaHeaderDto)
        );

        kafkaTemplate.send(producerRecord);

    }

    public void producerError(KafkaHeaderDto kafkaHeaderDto, String topic) {
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
