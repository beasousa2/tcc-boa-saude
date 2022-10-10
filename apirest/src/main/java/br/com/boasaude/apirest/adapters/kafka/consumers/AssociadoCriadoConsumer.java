package br.com.boasaude.apirest.adapters.kafka.consumers;

import br.com.boasaude.apirest.adapters.kafka.converter.CriarAssociadoConverter;
import br.com.boasaude.apirest.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.apirest.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.apirest.dto.AssociadoDto;
import br.com.boasaude.apirest.usecases.interfaces.NovoAssociadoCriadoUC;
import br.com.boasaude.associado.criar_associado_resposta.CriarAssociadoResposta;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssociadoCriadoConsumer {

    private final CriarAssociadoConverter converter;
    //private final NovoAssociadoCriadoUC usecase;
    @Value("${spring.kafka.consumer.criar.topic}")
    private String topico;

    @KafkaListener(topics = "${spring.kafka.consumer.criar.topic}",
            groupId = "${spring.kafka.consumer.criar.group-id}",
            errorHandler = "criarAssociadoErrorHandler")
    @SendTo
    public AssociadoDto consumer(@Payload CriarAssociadoResposta payload,
                         @Header(KafkaHeader.TRANSACTIONID) String transactionId,
                         @Header(KafkaHeader.CORRELATIONID) String correlationId,
                         final Acknowledgment ack) {
        AssociadoDto dto = converter.avroToDto(payload);
//        KafkaHeaderDto kafkaHeaderDto = KafkaHeader.retrieveHeader(transactionId, topico, correlationId, "Criar Novo Associado");
//        usecase.execute(dto, kafkaHeaderDto);
        ack.acknowledge();

        return dto;
    }
}
