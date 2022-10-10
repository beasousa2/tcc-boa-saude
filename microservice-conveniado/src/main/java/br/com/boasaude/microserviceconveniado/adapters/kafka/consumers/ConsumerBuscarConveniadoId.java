package br.com.boasaude.microserviceconveniado.adapters.kafka.consumers;

import br.com.boasaude.microserviceconveniado.adapters.kafka.converter.BuscarConveniadoIdConverter;
import br.com.boasaude.microserviceconveniado.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microserviceconveniado.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceconveniado.buscar_conveniado_id.BuscarConveniadoId;
import br.com.boasaude.microserviceconveniado.dto.BuscarConveniadoIdDto;
import br.com.boasaude.microserviceconveniado.usecase.interfaces.BuscarConveniadoIdUC;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class ConsumerBuscarConveniadoId {

    private final BuscarConveniadoIdConverter converter;
    private final BuscarConveniadoIdUC usecase;

    @Value("${spring.kafka.consumer.buscar-id.topic}")
    private String topicConsumer;

    @KafkaListener(topics = "${spring.kafka.consumer.buscar-id.topic}",
            groupId = "${spring.kafka.consumer.buscar-id.group-id}",
            errorHandler = "buscarConveniadoIdErrorHandler")
    public void consumer(@Payload BuscarConveniadoId payload,
                         @Header(KafkaHeader.TRANSACTIONID) String transactionId,
                         @Header(KafkaHeader.CORRELATIONID) String correlationId,
                         final Acknowledgment ack) {
        BuscarConveniadoIdDto dto = converter.avroToDto(payload);
        KafkaHeaderDto kafkaHeaderDto = KafkaHeader.retrieveHeader(transactionId, correlationId, topicConsumer, "Buscar Conveniado por Id");
        usecase.execute(dto, kafkaHeaderDto);
        ack.acknowledge();
    }
}
