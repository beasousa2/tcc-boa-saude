package br.com.boasaude.microserviceprestador.adapters.kafka.consumers;

import br.com.boasaude.microserviceprestador.adapters.converters.BuscarPrestadoresEspecialidadeConverter;
import br.com.boasaude.microserviceprestador.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microserviceprestador.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceprestador.buscar_prstadores_especialidade.BuscarPrestadoresEspecialidade;
import br.com.boasaude.microserviceprestador.dto.BuscarPrestadoresEspecialidadeDto;
import br.com.boasaude.microserviceprestador.usecase.interfaces.BuscarPretadoresEspecialidadeUC;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarColaboradoresEspecialidadeConsumer {

    private final BuscarPrestadoresEspecialidadeConverter converter;
    private final BuscarPretadoresEspecialidadeUC usecase;
    @Value("${spring.kafka.consumer.buscar-especialidade.topic}")
    private String topico;

    @KafkaListener(topics = "${spring.kafka.consumer.buscar-especialidade.topic}",
            groupId = "${spring.kafka.consumer.buscar-especialidade.group-id}",
            errorHandler = "buscarColaboradorEspecialidadeErrorHandler")
    public void consumer(@Payload BuscarPrestadoresEspecialidade payload,
                         @Header(KafkaHeader.TRANSACTIONID) String transactionId,
                         @Header(KafkaHeader.CORRELATIONID) String correlationId,
                         final Acknowledgment ack) {

        BuscarPrestadoresEspecialidadeDto dto = converter.avroToPrestadoresEspecialidadeDto(payload);
        KafkaHeaderDto kafkaHeaderDto = KafkaHeader.retrieveHeader(transactionId, correlationId, topico, "Buscar Colaboradores por Especialidade");
        usecase.executeProducer(dto, kafkaHeaderDto);
        ack.acknowledge();

    }
}
