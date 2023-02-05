package br.com.boasaude.orquestrador.usecase.impl;


import br.com.boasaude.microservicemarcarconsulta.verifica_debito_request.VerificaDebito;
import br.com.boasaude.orquestrador.adapters.kafka.convert.ConverterKafka;
import br.com.boasaude.orquestrador.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.orquestrador.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.orquestrador.adapters.kafka.producers.PagamentosProducer;
import br.com.boasaude.orquestrador.usecase.interfaces.PagamentosOrquestradorUC;
import br.com.boasaude.pagamentos.debito_verificado_reply.DebitoVerificadoReply;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PagamentosOrquestradorUCImpl implements PagamentosOrquestradorUC {


    private final PagamentosProducer producer;
    private final ConverterKafka converter;
    @Value("spring.kafka.producer.pagamentos.topic")
    private String topico;
    private final String transactionId = UUID.randomUUID().toString();
    private final String correlationId = UUID.randomUUID().toString();

    @Override
    public void verificarDebitos(VerificaDebito payload) {
        KafkaHeaderDto headerDto = KafkaHeader.retrieveHeader(transactionId, correlationId, topico, "Verifica Débitos Associado");
        producer.verificaDebito(payload, headerDto);
    }

    @Override
    public void debitoVerificado(DebitoVerificadoReply payload) {
        KafkaHeaderDto headerDto = KafkaHeader.retrieveHeader(transactionId, correlationId, topico, "Verifica Débitos Associado");
        producer.debitoVerificado(payload, headerDto);
    }
}
