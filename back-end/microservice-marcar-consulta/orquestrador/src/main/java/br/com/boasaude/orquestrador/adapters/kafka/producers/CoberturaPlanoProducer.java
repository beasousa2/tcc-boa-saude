package br.com.boasaude.orquestrador.adapters.kafka.producers;

import br.com.boasaude.coberturaplano.cobertura_plano_verificado_reply.CoberturaPlanoVerificado;
import br.com.boasaude.microservicemarcarconsulta.verifica_cobertura_plano_request.VerificaCoberturaPlano;

import br.com.boasaude.orquestrador.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.orquestrador.adapters.kafka.header.KafkaHeaderDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CoberturaPlanoProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    @Value("${spring.kafka.producer.cobertura-plano.topic}")
    private String topico;
    private final KafkaHeader kafkaHeader;

    public void producerSuccess(VerificaCoberturaPlano avro, KafkaHeaderDto kafkaHeaderDto) {

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
