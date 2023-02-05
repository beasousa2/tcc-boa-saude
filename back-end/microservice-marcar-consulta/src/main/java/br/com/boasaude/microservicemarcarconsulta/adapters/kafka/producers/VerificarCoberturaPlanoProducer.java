package br.com.boasaude.microservicemarcarconsulta.adapters.kafka.producers;

import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microservicemarcarconsulta.verifica_cobertura_plano_request.VerificaCoberturaPlano;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j
@Service
@RequiredArgsConstructor
public class VerificarCoberturaPlanoProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaHeader kafkaHeader;
    private String topico;

    public void producer(VerificaCoberturaPlano avro, KafkaHeaderDto kafkaHeaderDto) {
        log.info("MarcarConsulta: VerificaCoberturaPlanoProducer - INICIO");
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(
                topico,
                null,
                kafkaHeaderDto.getTransactionId(),
                avro,
                kafkaHeader.getHeaders(kafkaHeaderDto)
        );

        kafkaTemplate.send(producerRecord);
        log.info("MarcarConsulta: VerificaCoberturaPlanoProducer - FIM");
    }
}
