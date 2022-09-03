package br.com.boasaude.microserviceconveniado.adapters.kafka.producer;

import br.com.boasaude.microserviceconveniado.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microserviceconveniado.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceconveniado.buscar_conveniado_id_resposta.BuscarConveniadoIdResposta;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuscarConveniadoIdProducer {


    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaHeader kafkaHeader;
    @Value("${spring.kafka.producer.buscar-id.topic}")
    private String topico;

    public void producerSuccess(BuscarConveniadoIdResposta avro, KafkaHeaderDto kafkaHeaderDto) {

        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(
                topico,
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
