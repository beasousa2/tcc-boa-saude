package br.com.boasaude.microservicemarcarconsulta.usecase.impl;

import br.com.boasaude.microservicemarcarconsulta.adapters.database.entity.Consulta;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.converters.ConverterKafka;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.producers.VerificaDebitosProducer;
import br.com.boasaude.microservicemarcarconsulta.usecase.interfaces.PagamentosUC;
import br.com.boasaude.microservicemarcarconsulta.verifica_debito_request.VerificaDebito;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PagamentosUCImpl implements PagamentosUC {

    private final VerificaDebitosProducer producer;
    private final ConverterKafka converterKafka;
    private String transactionId = UUID.randomUUID().toString();
    private String correlationId = UUID.randomUUID().toString();
    @Value("${spring.kafka.producer.consultar-cobertura-plano.topic}")
    private String topico;

    @Override
    public void execute(Consulta consulta) {
        KafkaHeaderDto headers = KafkaHeader.retrieveHeader(transactionId, topico, correlationId, "Verifica Debitos Pagamentos");
        final VerificaDebito verificaDebito = converterKafka.verificaDebito(consulta);
        producer.producer(verificaDebito, headers);

    }
}
