package br.com.boasaude.microserviceconveniado.adapters.kafka.consumers;

import br.com.boasaude.microserviceconveniado.adapters.kafka.converter.BuscarConveniadoIdConverter;
import br.com.boasaude.microserviceconveniado.buscar_conveniado_id.BuscarConveniadoId;
import br.com.boasaude.microserviceconveniado.dto.BuscarConveniadoIdDto;
import br.com.boasaude.microserviceconveniado.usecase.interfaces.BuscarConveniadoIdUC;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ConsumerBuscarConveniadoId {

    private final BuscarConveniadoIdConverter converter;
    private final BuscarConveniadoIdUC usecase;

    @Value("${spring.kafka.consumer.buscar-id.topic}")
    private String topicConsumer;

    public void consumer(@Payload BuscarConveniadoId payload, final Acknowledgment ack) {
        BuscarConveniadoIdDto dto = converter.avroToDto(payload);
        usecase.execute(dto);
        ack.acknowledge();
    }
}
