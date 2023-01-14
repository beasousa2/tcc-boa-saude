package br.com.boasaude.pagamentos.adapters.kafka.producer;

import br.com.boasaude.pagamentos.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.pagamentos.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.pagamentos.debito_verificado_reply.DebitoVerificadoReply;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DebitoVerificadoProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    @Value("${spring.kafka.producer.cobertura-plano.topic}")
    private String topico;
    private final KafkaHeader kafkaHeader;

    public void producerSuccess(DebitoVerificadoReply avro, KafkaHeaderDto kafkaHeaderDto) {
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(
                topico,
                null,
                kafkaHeaderDto.getTransactionId(),
                avro,
                kafkaHeader.getHeaders(kafkaHeaderDto)
        );
        kafkaTemplate.send(producerRecord);
    }

    public void producerError() {}
}
