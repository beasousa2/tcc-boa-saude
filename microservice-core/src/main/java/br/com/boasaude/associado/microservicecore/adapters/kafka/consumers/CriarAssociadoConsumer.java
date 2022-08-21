package br.com.boasaude.associado.microservicecore.adapters.kafka.consumers;

//import br.com.boasaude.associado.microservicecore.adapters.kafka.converts.CriarNovoAssociadoConverter;
//import br.com.boasaude.associado.criar_associado_novo_realizada.CriaAssociadoNovoRealizada;
//import br.com.boasaude.associado.microservicecore.adapters.kafka.header.KafkaHeader;
//import br.com.boasaude.associado.microservicecore.adapters.kafka.header.KafkaHeaderDto;
//import br.com.boasaude.associado.microservicecore.dto.AssociadoDto;
//import br.com.boasaude.associado.microservicecore.usecase.interfaces.CriarNovoAssociadoUC;
import br.com.boasaude.associado.apirest.criar_associado_novo_realizada.CriaAssociadoNovoRealizada;
import br.com.boasaude.associado.microservicecore.adapters.kafka.converts.CriarNovoAssociadoConverter;
import br.com.boasaude.associado.microservicecore.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.associado.microservicecore.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.associado.microservicecore.dto.AssociadoDto;
import br.com.boasaude.associado.microservicecore.usecase.interfaces.CriarNovoAssociadoUC;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class CriarAssociadoConsumer {

    private final CriarNovoAssociadoConverter converter;
    private final CriarNovoAssociadoUC criarNovoAssociadoUC;


    @KafkaListener(topics = "${spring.kafka.consumer.criar.topic}",
            groupId = "${spring.kafka.consumer.criar.group-id}",
            errorHandler = "criarAssociadoErrorHandler")
    public void consumer(@Payload CriaAssociadoNovoRealizada payload,
                         @Header(KafkaHeader.TRANSACTIONID) String transactionId,
                         @Header(KafkaHeaders.RECEIVED_TOPIC) String topicConsumer,
                         @Header(KafkaHeader.CORRELATIONID) String correlationId,
                         final Acknowledgment ack) {

        KafkaHeaderDto headers = KafkaHeader.retrieveHeader(transactionId, topicConsumer, correlationId, "Criar novo associado no banco de dados");

        AssociadoDto dto = converter.avroToDto(payload);

        criarNovoAssociadoUC.execute(dto);

        ack.acknowledge();
    }

}
