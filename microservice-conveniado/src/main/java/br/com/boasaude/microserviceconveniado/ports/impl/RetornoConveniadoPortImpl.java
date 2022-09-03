package br.com.boasaude.microserviceconveniado.ports.impl;

import br.com.boasaude.microserviceconveniado.adapters.kafka.converter.RetornoConveniadoConverter;
import br.com.boasaude.microserviceconveniado.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceconveniado.adapters.kafka.producer.RetornaConveniadoProducer;
import br.com.boasaude.microserviceconveniado.dto.conveniado.ConveniadoDto;
import br.com.boasaude.microserviceconveniado.ports.interfaces.RetornoConveniadoPort;
import br.com.boasaude.microserviceconveniado.retorno_conveniado.RetornoConveniado;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RetornoConveniadoPortImpl implements RetornoConveniadoPort {

    private final RetornaConveniadoProducer producer;
    private final RetornoConveniadoConverter converter;

    private String topic;
    private String correlationId = UUID.randomUUID().toString();
    private String transactionId = UUID.randomUUID().toString();


    @Override
    public void execute(ConveniadoDto dto) {
        RetornoConveniado avro = converter.dtoToAvro(dto);
        KafkaHeaderDto kafkaDto = KafkaHeaderDto.builder()
                .correlationId(correlationId)
                .transactionId(transactionId)
                .topico(topic)
                .fluxo("RETORNO_CONVENIADO")
                .build();
        producer.producerSuccess(avro, kafkaDto, topic);
    }
}
