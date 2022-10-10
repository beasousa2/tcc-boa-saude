package br.com.boasaude.apirest.port.impl;

import br.com.boasaude.apirest.adapters.kafka.producers.CriarAssociadoProducer;
import br.com.boasaude.apirest.port.interfaces.CriarAssociadoPort;
import br.com.boasaude.apirest.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.associado.criar_associado.CriarAssociado;
import br.com.boasaude.associado.criar_associado_resposta.CriarAssociadoResposta;
import lombok.RequiredArgsConstructor;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;


@Component
@RequiredArgsConstructor
public class CriarAssociadoPortImpl implements CriarAssociadoPort {
    private final CriarAssociadoProducer producer;

    @Override
    public CriarAssociadoResposta execute(CriarAssociado avro, KafkaHeaderDto kafkaDto) throws InterruptedException, ExecutionException {

        RequestReplyFuture<String, CriarAssociado, CriarAssociadoResposta> sendAndReceive = producer.producerSuccess(avro, kafkaDto);
        ConsumerRecord<String, CriarAssociadoResposta> consumerRecord = sendAndReceive.get();
        return consumerRecord.value();
    }
}
