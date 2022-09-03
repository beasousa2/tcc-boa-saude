package br.com.boasaude.microserviceconveniado.adapters.kafka.producer;

import br.com.boasaude.microserviceconveniado.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microserviceconveniado.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceconveniado.buscar_conveniado_nome_especialidade_resposta.BuscarConveniadoNomeEspecialidadeResposta;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuscarConveniadoNomeEspencialidadeProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaHeader kafkaHeader;
    @Value("${spring.kafka.producer.buscar-nome-especialidade.topic}")
    private String topico;

    public void producerSuccess(BuscarConveniadoNomeEspecialidadeResposta avro, KafkaHeaderDto kafkaHeaderDto) {

        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(
                topico,
                null,
                kafkaHeaderDto.getTransactionId(),
                avro,
                kafkaHeader.getHeaders(kafkaHeaderDto)
        );
        kafkaTemplate.send(producerRecord);
    }

    public void producerError(KafkaHeaderDto kafkaHeaderDto) {
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(
                topico,
                null,
                kafkaHeaderDto.getTransactionId(),
                null,
                kafkaHeader.getHeaders(kafkaHeaderDto)
        );

        kafkaTemplate.send(producerRecord);
    }

}
