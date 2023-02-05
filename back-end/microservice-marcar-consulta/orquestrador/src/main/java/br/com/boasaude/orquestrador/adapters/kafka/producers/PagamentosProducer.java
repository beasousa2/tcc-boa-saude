package br.com.boasaude.orquestrador.adapters.kafka.producers;


import br.com.boasaude.microservicemarcarconsulta.verifica_debito_request.VerificaDebito;
import br.com.boasaude.orquestrador.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.orquestrador.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.pagamentos.debito_verificado_reply.DebitoVerificadoReply;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PagamentosProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    @Value("${spring.kafka.producer.cobertura-plano.topic}")
    private String verificaDebitoTopico;
    @Value("spring.kafka.producer.marcar-consulta.topic")
    private String debitoVerificadoTopico;
    private final KafkaHeader kafkaHeader;

    public void verificaDebito(VerificaDebito avro, KafkaHeaderDto kafkaHeaderDto) {
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(
                verificaDebitoTopico,
                null,
                kafkaHeaderDto.getTransactionId(),
                avro,
                kafkaHeader.getHeaders(kafkaHeaderDto)
        );
        kafkaTemplate.send(producerRecord);
    }

    public void debitoVerificado(DebitoVerificadoReply avro, KafkaHeaderDto kafkaHeaderDto) {
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(
                debitoVerificadoTopico,
                null,
                kafkaHeaderDto.getTransactionId(),
                avro,
                kafkaHeader.getHeaders(kafkaHeaderDto)
        );
        kafkaTemplate.send(producerRecord);
    }
}
