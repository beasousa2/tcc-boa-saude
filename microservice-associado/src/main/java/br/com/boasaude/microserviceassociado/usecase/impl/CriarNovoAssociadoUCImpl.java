package br.com.boasaude.microserviceassociado.usecase.impl;

import br.com.boasaude.associado.criar_associado_resposta.CriarAssociadoResposta;
import br.com.boasaude.microserviceassociado.adapters.entities.Associado;
import br.com.boasaude.microserviceassociado.adapters.kafka.converts.CriarNovoAssociadoConverter;
import br.com.boasaude.microserviceassociado.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microserviceassociado.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceassociado.adapters.kafka.producers.CriarNovoAssociadoProducer;
import br.com.boasaude.microserviceassociado.dto.CriaAssociadoDto;
import br.com.boasaude.microserviceassociado.ports.interfaces.SalvarAssociadoBancoPort;
import br.com.boasaude.microserviceassociado.usecase.interfaces.CriarNovoAssociadoUC;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CriarNovoAssociadoUCImpl implements CriarNovoAssociadoUC {

    private final SalvarAssociadoBancoPort salvarAssociadoPort;
    private final CriarNovoAssociadoConverter associadoConverter;
    private final CriarNovoAssociadoProducer producer;
    private final String transactionId = UUID.randomUUID().toString();
    private final String correlationId = UUID.randomUUID().toString();
    @Value("${spring.kafka.consumer.criar.topic}")
    private String topicConsumer;

    public String execute(CriaAssociadoDto dto) {
        KafkaHeaderDto headers = KafkaHeader.retrieveHeader(transactionId, topicConsumer, correlationId, "Novo associado");
        Associado associado = associadoConverter.dtoToEntity(dto);
        CriarAssociadoResposta avro = salvarAssociadoPort.execute(associado);
        producer.producerSuccess(avro, headers);
        return associado.getId();
    }
}
