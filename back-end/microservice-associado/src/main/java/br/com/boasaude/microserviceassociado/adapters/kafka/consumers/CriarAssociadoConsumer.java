package br.com.boasaude.microserviceassociado.adapters.kafka.consumers;

import br.com.boasaude.associado.criar_associado.CriarAssociado;
import br.com.boasaude.microserviceassociado.adapters.kafka.converts.CriarNovoAssociadoConverter;
import br.com.boasaude.microserviceassociado.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microserviceassociado.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceassociado.dto.CriaAssociadoDto;
import br.com.boasaude.microserviceassociado.usecase.interfaces.CriarNovoAssociadoUC;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
public class CriarAssociadoConsumer {

    private final CriarNovoAssociadoConverter converter;
    private final CriarNovoAssociadoUC criarNovoAssociadoUC;

    @Value("${spring.kafka.consumer.criar.topic}")
    private String topicConsumer;


    @KafkaListener(topics = "${spring.kafka.consumer.criar.topic}",
            groupId = "${spring.kafka.consumer.consulta.group-id}",
            errorHandler = "criarAssociadoErrorHandler")
    public void consumer(@Payload CriarAssociado payload,
                         @Header(KafkaHeader.TRANSACTIONID) String transactionId,
                         @Header(KafkaHeader.CORRELATIONID) String correlationId,
                         final Acknowledgment ack) {

        KafkaHeaderDto headers = KafkaHeader.retrieveHeader(transactionId, topicConsumer, correlationId, "Criar novo associado no banco de dados");

        CriaAssociadoDto dto = converter.avroToDto(payload);

        criarNovoAssociadoUC.execute(dto);

        ack.acknowledge();
    }

}
