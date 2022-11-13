package br.com.boasaude.microserviceprestador.adapters.kafka.consumers;

import br.com.boasaude.microservicemarcarconsulta.marcar_nova_consulta_resposta.MarcarNovaConsultaResposta;
import br.com.boasaude.microserviceprestador.adapters.converters.ConsultaConverter;
import br.com.boasaude.microserviceprestador.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microserviceprestador.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceprestador.dto.ConsultaDto;
import br.com.boasaude.microserviceprestador.usecase.interfaces.ConsultaUC;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NovaConsultaConsumer {

    private final ConsultaConverter converter;
    private final ConsultaUC usecase;
    @Value("${spring.kafka.consumer.nova-consulta.topic}")
    private String topic;

    public void consumer(@Payload MarcarNovaConsultaResposta payload,
                         @Header(KafkaHeader.TRANSACTIONID) String transactionId,
                         @Header(KafkaHeader.CORRELATIONID) String correlationId,
                         final Acknowledgment ack) {
        KafkaHeaderDto kafkaHeaderDto = KafkaHeader.retrieveHeader(transactionId, correlationId, topic, "Nova consulta");
        ConsultaDto consultaDto = converter.converter(payload);
        usecase.execute(consultaDto);
        ack.acknowledge();
    }
}
