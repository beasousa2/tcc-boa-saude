package br.com.boasaude.apirest.adapters.kafka.producers;

import br.com.boasaude.apirest.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.apirest.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.associado.criar_associado.CriarAssociado;
import br.com.boasaude.associado.criar_associado_resposta.CriarAssociadoResposta;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CriarAssociadoProducer {

    private final ReplyingKafkaTemplate<String, CriarAssociado, CriarAssociadoResposta> kafkaTemplate;
    private final KafkaHeader kafkaHeader;
    @Value("${spring.kafka.producer.criar.topic}")
    private String topico;

    public RequestReplyFuture<String, CriarAssociado, CriarAssociadoResposta> producerSuccess(CriarAssociado avro, KafkaHeaderDto kafkaHeaderDto) {

        ProducerRecord<String, CriarAssociado> producerRecord = new ProducerRecord<>(
                topico,
                null,
                kafkaHeaderDto.getTransactionId(),
                avro,
                kafkaHeader.getHeaders(kafkaHeaderDto)
        );

        return kafkaTemplate.sendAndReceive(producerRecord);

    }

    public void producerError(KafkaHeaderDto kafkaHeaderDto) {
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(
                kafkaHeaderDto.getTopico(),
                null,
                kafkaHeaderDto.getTransactionId(),
                null,
                kafkaHeader.getHeaders(kafkaHeaderDto)
        );

        kafkaTemplate.send((Message<?>) producerRecord);
    }
}
