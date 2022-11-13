package br.com.boasaude.microserviceprestador.adapters.kafka.producers;

import br.com.boasaude.microserviceprestador.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microserviceprestador.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceprestador.buscar_prestador_id_resposta.BuscarPrestadorIdResposta;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuscarColaboradorIdProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaHeader kafkaHeader;
    @Value("${spring.kafka.producer.buscar-id.topic}")
    private String topico;

    public void producerSuccess(BuscarPrestadorIdResposta avro, KafkaHeaderDto kafkaHeaderDto) {

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
