package br.com.boasaude.microservicemarcarconsulta.adapters.kafka.producers;

import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microservicemarcarconsulta.verifica_debito_request.VerificaDebito;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j
@Service
@RequiredArgsConstructor
public class VerificaDebitosProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaHeader kafkaHeader;

    @Value("${spring.kafka.producer.verifica-pagamentos.topic}")
    private String topico;

    public void producer(VerificaDebito avro, KafkaHeaderDto kafkaHeaderDto) {
        log.info("MarcarConsulta: VerficaDebitosProducer Success - INICIO");
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(
                topico,
                null,
                kafkaHeaderDto.getTransactionId(),
                avro,
                kafkaHeader.getHeaders(kafkaHeaderDto)
        );

        kafkaTemplate.send(producerRecord);
        log.info("\"MarcarConsulta: VerficaDebitosProducer Success - FIM");
    }
}
