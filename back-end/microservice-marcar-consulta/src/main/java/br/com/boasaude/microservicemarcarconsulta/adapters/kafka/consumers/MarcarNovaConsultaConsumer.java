package br.com.boasaude.microservicemarcarconsulta.adapters.kafka.consumers;

import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.converters.MarcarNovaConsultaConverter;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microservicemarcarconsulta.dto.MarcarNovaConsultaDto;
import br.com.boasaude.microservicemarcarconsulta.marcar_nova_consulta.MarcarNovaConsulta;
import br.com.boasaude.microservicemarcarconsulta.usecase.interfaces.MarcarNovaConsultaUC;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Log4j
@Service
@RequiredArgsConstructor
public class MarcarNovaConsultaConsumer {

    private final MarcarNovaConsultaUC usecase;
    private final MarcarNovaConsultaConverter converter;

    @Value("${spring.kafka.consumer.marcar-consulta.topic}")
    private String topico;

    @KafkaListener(topics = "${spring.kafka.consumer.marcar-consulta.topic}",
            groupId = "${spring.kafka.consumer.marcar-consulta.group-id}",
            errorHandler = "marcarNovaConsultaHandler")
    public void consumer(@Payload MarcarNovaConsulta payload,
                         @Header(KafkaHeader.TRANSACTIONID) String transactionId,
                         @Header(KafkaHeader.CORRELATIONID) String correlationId,
                         final Acknowledgment ack) {
        log.info("MarcarNovaConsultaConsumer - INICIO");

        KafkaHeaderDto headers = KafkaHeader.retrieveHeader(transactionId, topico, correlationId, "Adicionar nova consulta");



        ack.acknowledge();
        log.info("MarcarNovaConsultaConsumer - FIM");

    }

}
