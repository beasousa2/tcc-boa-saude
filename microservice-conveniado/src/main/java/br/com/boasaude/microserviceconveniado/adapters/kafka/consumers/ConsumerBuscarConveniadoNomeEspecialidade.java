package br.com.boasaude.microserviceconveniado.adapters.kafka.consumers;

import br.com.boasaude.microserviceconveniado.adapters.kafka.converter.BuscarConveniadoNomeEspecialidadeConverter;
import br.com.boasaude.microserviceconveniado.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microserviceconveniado.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceconveniado.buscar_conveniado_nome_especialidade.BuscarConveniadoNomeEspecialidade;
import br.com.boasaude.microserviceconveniado.dto.BuscarConveniadoNomeEspecialidadeDto;
import br.com.boasaude.microserviceconveniado.usecase.interfaces.BuscarConveniadoNomeEspecialidadeUC;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConsumerBuscarConveniadoNomeEspecialidade {

    private final BuscarConveniadoNomeEspecialidadeConverter converter;
    private final BuscarConveniadoNomeEspecialidadeUC usecase;
    @Value("${spring.kafka.consumer.buscar-nome-especialidade.topic}")
    private String topico;


    public void consumer(@Payload BuscarConveniadoNomeEspecialidade payload,
                         @Header(KafkaHeader.TRANSACTIONID) String transactionId,
                         @Header(KafkaHeader.CORRELATIONID) String correlationId,
                         final Acknowledgment ack ) {

        KafkaHeaderDto headerDto = KafkaHeader.retrieveHeader(transactionId, topico, correlationId, "Buscar Conveniados por Especialidade");
        BuscarConveniadoNomeEspecialidadeDto dto = converter.avroToDto(payload);
        usecase.execute(dto, headerDto);
        ack.acknowledge();
    }
}
