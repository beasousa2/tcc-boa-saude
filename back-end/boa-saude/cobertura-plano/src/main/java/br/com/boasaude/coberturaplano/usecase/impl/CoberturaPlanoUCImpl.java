package br.com.boasaude.coberturaplano.usecase.impl;

import br.com.boasaude.coberturaplano.adapters.kafka.convert.ConverterKafka;
import br.com.boasaude.coberturaplano.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.coberturaplano.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.coberturaplano.adapters.kafka.producers.CoberturaPlanoVerificadoProducer;
import br.com.boasaude.coberturaplano.cobertura_plano_verificado_reply.CoberturaPlanoVerificado;
import br.com.boasaude.coberturaplano.dto.CoberturaPlanoVerificadoDTO;
import br.com.boasaude.coberturaplano.dto.VerificaCoberturaPlanoDto;
import br.com.boasaude.coberturaplano.ports.interfaces.CoberturaPlanoPort;
import br.com.boasaude.coberturaplano.usecase.interfaces.CoberturaPlanoUC;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CoberturaPlanoUCImpl implements CoberturaPlanoUC {

    private final CoberturaPlanoPort port;
    private final CoberturaPlanoVerificadoProducer producer;
    private final ConverterKafka converterKafka;
    private final String transactionId = UUID.randomUUID().toString();
    private final String correlationId = UUID.randomUUID().toString();
    @Value("${spring.kafka.producer.cobertura-plano.topic}")
    private String topico;

    @Override
    public void verification(VerificaCoberturaPlanoDto dto) {
        KafkaHeaderDto headers = KafkaHeader.retrieveHeader(transactionId, topico, correlationId, "Verifica cobertura do plano");
        CoberturaPlanoVerificadoDTO verification = port.verificar(dto);
        CoberturaPlanoVerificado avro = converterKafka.dtoToAvro(verification);
        if(verification.getIsCoberto()) {
            producer.producerSuccess(avro, headers);
        }
        producer.producerError(avro, headers);
    }
}
