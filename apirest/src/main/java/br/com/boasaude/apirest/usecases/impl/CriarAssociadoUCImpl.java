package br.com.boasaude.apirest.usecases.impl;

import br.com.boasaude.apirest.adapters.kafka.converter.CriarAssociadoConverter;
import br.com.boasaude.apirest.dto.AssociadoDto;
import br.com.boasaude.apirest.usecases.interfaces.CriarAssociadoUC;
import br.com.boasaude.apirest.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.apirest.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.apirest.dto.form.CriarAssociadoForm;
import br.com.boasaude.apirest.port.interfaces.CriarAssociadoPort;
import br.com.boasaude.associado.criar_associado.CriarAssociado;
import br.com.boasaude.associado.criar_associado_resposta.CriarAssociadoResposta;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
public class CriarAssociadoUCImpl implements CriarAssociadoUC {
    private final CriarAssociadoPort port;
    private final CriarAssociadoConverter converter;
    @Value("${spring.kafka.producer.criar.topic}")
    private String topico;
    private String correlationId = UUID.randomUUID().toString();
    private String transactionId = UUID.randomUUID().toString();

    @Override
    public AssociadoDto execute(CriarAssociadoForm form) throws ExecutionException, InterruptedException {
        CriarAssociado avro = converter.dtoToAvro(form);
        KafkaHeaderDto kafkaHeaderDto = KafkaHeader.retrieveHeader(transactionId, topico, correlationId, "Criar novo associado");
        CriarAssociadoResposta resposta = port.execute(avro, kafkaHeaderDto);
        return converter.avroToDto(resposta);

    }
}
