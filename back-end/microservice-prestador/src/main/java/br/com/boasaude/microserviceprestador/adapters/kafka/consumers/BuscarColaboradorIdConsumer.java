package br.com.boasaude.microserviceprestador.adapters.kafka.consumers;

import br.com.boasaude.microserviceprestador.adapters.converters.BuscarPrestadorIdConverter;
import br.com.boasaude.microserviceprestador.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microserviceprestador.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceprestador.dto.BuscarPrestadorIdDto;
import br.com.boasaude.microserviceprestador.usecase.interfaces.BuscarPrestadorIdUC;
import br.com.boasaude.microserviceprestador.buscar_prestador_id.BuscarPrestadorId;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarColaboradorIdConsumer {

    private final BuscarPrestadorIdConverter converter;
    private final BuscarPrestadorIdUC usecase;
    @Value("${spring.kafka.consumer.buscar-id.topic}")
    private String topico;

    public void consumer(@Payload BuscarPrestadorId payload,
                         @Header(KafkaHeader.TRANSACTIONID) String transactionId,
                         @Header(KafkaHeader.CORRELATIONID) String correlationId,
                         final Acknowledgment ack
                         ){
        BuscarPrestadorIdDto dto = converter.avroToBuscaPrestadorIdDto(payload);
        KafkaHeaderDto kafkaHeaderDto = KafkaHeader.retrieveHeader(transactionId, correlationId, topico, "Buscar Prestador pelo Id");
        usecase.executeProducer(dto, kafkaHeaderDto);
        ack.acknowledge();

    }

}
