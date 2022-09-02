package br.com.boasaude.associado.microservicecore.adapters.kafka.consumers;

import br.com.boasaude.associado.criar_associado_novo_realizada.CriaAssociadoNovoRealizada;
import br.com.boasaude.associado.microservicecore.adapters.kafka.converts.CriarNovoAssociadoConverter;
import br.com.boasaude.associado.microservicecore.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.associado.microservicecore.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.associado.microservicecore.dto.CriaAssociadoDto;
import br.com.boasaude.associado.microservicecore.usecase.interfaces.CriarNovoAssociadoUC;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CriarAssociadoConsumer {

    private final CriarNovoAssociadoConverter converter;
    private final CriarNovoAssociadoUC criarNovoAssociadoUC;

    @Value("${spring.kafka.consumer.criar.topic}")
    private String topicConsumer;


    @KafkaListener(topics = "${spring.kafka.consumer.criar.topic}",
            groupId = "${spring.kafka.consumer.criar.group-id}",
            errorHandler = "criarAssociadoErrorHandler")

    public void consumer(@Payload CriaAssociadoNovoRealizada payload,
                         @Header(KafkaHeader.TRANSACTIONID) String transactionId,
                         final Acknowledgment ack) {

        String correlationId = UUID.randomUUID().toString();

        KafkaHeaderDto headers = KafkaHeader.retrieveHeader(transactionId, topicConsumer, correlationId, "Criar novo associado no banco de dados");

        CriaAssociadoDto dto = converter.avroToDto(payload);

        criarNovoAssociadoUC.execute(dto);

        ack.acknowledge();
    }

}
