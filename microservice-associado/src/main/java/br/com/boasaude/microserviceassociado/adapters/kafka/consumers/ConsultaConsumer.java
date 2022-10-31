package br.com.boasaude.microserviceassociado.adapters.kafka.consumers;

import br.com.boasaude.microserviceassociado.adapters.kafka.converts.ConsultaConverterKafka;
import br.com.boasaude.microserviceassociado.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microserviceassociado.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceassociado.dto.ConsultaDto;
import br.com.boasaude.microserviceassociado.usecase.interfaces.MarcarConsultaUC;
import br.com.boasaude.microservicemarcarconsulta.marcar_nova_consulta_resposta.MarcarNovaConsultaResposta;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsultaConsumer {

    private final ConsultaConverterKafka converter;
    private final MarcarConsultaUC usecase;
    @Value("${spring.kafka.consumer.marcar-consulta.topic}")
    private String topic;

    @KafkaListener(topics = "${spring.kafka.consumer.marcar-consulta.topic}",
            groupId = "${spring.kafka.consumer.consulta.group-id}",
            errorHandler = "marcarConsultaErrorHandler")
    public void consumer(@Payload MarcarNovaConsultaResposta payload,
                         @Header(KafkaHeader.TRANSACTIONID) String transactionId,
                         @Header(KafkaHeader.CORRELATIONID) String correlationId,
                         final Acknowledgment ack) {
        KafkaHeaderDto headers = KafkaHeader.retrieveHeader(transactionId, topic, correlationId, "Nova consulta");
        ConsultaDto consultaDto = converter.converter(payload);
        usecase.execute(consultaDto);
        ack.acknowledge();
    }
}
