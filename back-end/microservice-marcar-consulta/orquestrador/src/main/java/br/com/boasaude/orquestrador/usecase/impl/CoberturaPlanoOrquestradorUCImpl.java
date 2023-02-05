package br.com.boasaude.orquestrador.usecase.impl;

import br.com.boasaude.microservicemarcarconsulta.verifica_cobertura_plano_request.VerificaCoberturaPlano;
import br.com.boasaude.orquestrador.adapters.kafka.convert.ConverterKafka;
import br.com.boasaude.orquestrador.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.orquestrador.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.orquestrador.adapters.kafka.producers.CoberturaPlanoProducer;
import br.com.boasaude.orquestrador.usecase.interfaces.CoberturaPlanoOrquestradorUC;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CoberturaPlanoOrquestradorUCImpl implements CoberturaPlanoOrquestradorUC {

    private final CoberturaPlanoProducer producer;
    private final ConverterKafka converterKafka;
    private final String transactionId = UUID.randomUUID().toString();
    private final String correlationId = UUID.randomUUID().toString();
    @Value("${spring.kafka.producer.cobertura-plano.topic}")
    private String topico;

    @Override
    public void execute(VerificaCoberturaPlano avro) {
        KafkaHeaderDto headers = KafkaHeader.retrieveHeader(transactionId, topico, correlationId, "Verifica débitos existentes");
        producer.producerSuccess(avro, headers);
    }
}
