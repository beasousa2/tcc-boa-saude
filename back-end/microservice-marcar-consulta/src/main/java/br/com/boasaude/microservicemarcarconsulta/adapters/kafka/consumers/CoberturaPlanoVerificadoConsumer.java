package br.com.boasaude.microservicemarcarconsulta.adapters.kafka.consumers;

import br.com.boasaude.coberturaplano.cobertura_plano_verificado_reply.CoberturaPlanoVerificado;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.converters.ConverterKafka;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microservicemarcarconsulta.dto.CoberturaPlanoReplyDto;
import br.com.boasaude.microservicemarcarconsulta.usecase.interfaces.CoberturaPlanoUC;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoberturaPlanoVerificadoConsumer {

    private final ConverterKafka converterKafka;
    private final CoberturaPlanoUC planoUC;

    @KafkaListener(topics = "spring.kafka.consumer.consultar-cobertura-plano.topic",
            groupId = "spring.kafka.consumer.consulta-cobertura-plano.group-id"    )
    public void consumer(CoberturaPlanoVerificado payload,
                         @Header(KafkaHeader.TRANSACTIONID) String transactionId,
                         @Header(KafkaHeader.CORRELATIONID) String correlationId,
                         final Acknowledgment ack) {

        final CoberturaPlanoReplyDto replyDto = converterKafka.avroToDto(payload);
        planoUC.coberturaPlanoConsultada(replyDto);
        ack.acknowledge();

    }
}
