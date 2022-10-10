package br.com.boasaude.microservicemarcarconsulta.adapters.kafka.producers;

import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microservicemarcarconsulta.marcar_nova_consulta_resposta.MarcarNovaConsultaResposta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Log4j
@Component
@RequiredArgsConstructor
public class MarcarNovaConsultaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaHeader kafkaHeader;

    @Value("${spring.kafka.producer.marcar-consulta.topic}")
    private String topico;

    public void producerSuccess(MarcarNovaConsultaResposta avro,
                                KafkaHeaderDto kafkaHeaderDto
                                ) {
        log.info("MarcarNovaConsultaProducer Success - INICIO");
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(
                topico,
                null,
                kafkaHeaderDto.getTransactionId(),
                avro,
                kafkaHeader.getHeaders(kafkaHeaderDto)
        );

        kafkaTemplate.send(producerRecord);
        log.info("MarcarNovaConsultaProducer Success - FIM");
    }

    public void producerError(KafkaHeaderDto kafkaHeaderDto) {
        log.info("MarcarNovaConsultaProducer ERROR - INICIO");
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(
                topico,
                null,
                kafkaHeaderDto.getTransactionId(),
                null,
                kafkaHeader.getHeaders(kafkaHeaderDto)
        );

        kafkaTemplate.send(producerRecord);
        log.info("MarcarNovaConsultaProducer ERROR - INICIO");
    }
}
