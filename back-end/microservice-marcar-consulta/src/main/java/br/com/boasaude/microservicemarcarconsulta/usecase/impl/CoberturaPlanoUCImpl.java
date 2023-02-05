package br.com.boasaude.microservicemarcarconsulta.usecase.impl;

import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.converters.ConverterKafka;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.producers.VerificarCoberturaPlanoProducer;
import br.com.boasaude.microservicemarcarconsulta.dto.CoberturaPlanoReplyDto;
import br.com.boasaude.microservicemarcarconsulta.dto.CoberturaPlanoRequestDto;
import br.com.boasaude.microservicemarcarconsulta.usecase.interfaces.CoberturaPlanoUC;
import br.com.boasaude.microservicemarcarconsulta.usecase.interfaces.ConsultaUC;
import br.com.boasaude.microservicemarcarconsulta.verifica_cobertura_plano_request.VerificaCoberturaPlano;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CoberturaPlanoUCImpl implements CoberturaPlanoUC {

    private final VerificarCoberturaPlanoProducer producer;
    private final ConsultaUC consultaUC;
    private final ConverterKafka kafkaConverter;
    private String transactionId = UUID.randomUUID().toString();
    private String correlationId = UUID.randomUUID().toString();
    @Value("${spring.kafka.producer.consultar-cobertura-plano.topic}")
    private String topico;
    @Override
    public void consultaCoberturaPlano(CoberturaPlanoRequestDto dto) {
        KafkaHeaderDto headers = KafkaHeader.retrieveHeader(transactionId, topico, correlationId, "Verifica Cobertura Plano");
        VerificaCoberturaPlano avro = kafkaConverter.dtoToAvro(dto);
        producer.producer(avro, headers);
    }

    @Override
    public void coberturaPlanoConsultada(CoberturaPlanoReplyDto dto) {
        if (dto.getIsCoberto()) {
            consultaUC.execute(dto);
        }

    }
}
