package br.com.boasaude.coberturaplano.adapters.kafka.producers;

import br.com.boasaude.coberturaplano.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.coberturaplano.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.coberturaplano.cobertura_plano_verificado_reply.CoberturaPlanoVerificado;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CoberturaPlanoVerificadoProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private String topico;
    private final KafkaHeader kafkaHeader;

    public void producerSuccess(CoberturaPlanoVerificado avro, KafkaHeaderDto kafkaHeaderDto) {

        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(
                topico,
                null,
                kafkaHeaderDto.getTransactionId(),
                avro,
                kafkaHeader.getHeaders(kafkaHeaderDto)
        );
        kafkaTemplate.send(producerRecord);
    }

    public void producerError(CoberturaPlanoVerificado avro, KafkaHeaderDto kafkaHeaderDto){

    }
}
