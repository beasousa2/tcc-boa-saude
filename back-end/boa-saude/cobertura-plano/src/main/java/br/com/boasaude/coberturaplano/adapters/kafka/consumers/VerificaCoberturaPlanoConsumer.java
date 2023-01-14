package br.com.boasaude.coberturaplano.adapters.kafka.consumers;

import br.com.boasaude.coberturaplano.adapters.kafka.convert.ConverterKafka;
import br.com.boasaude.coberturaplano.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.coberturaplano.dto.VerificaCoberturaPlanoDto;
import br.com.boasaude.coberturaplano.usecase.interfaces.CoberturaPlanoUC;
import br.com.boasaude.microservicemarcarconsulta.verifica_cobertura_plano_request.VerificaCoberturaPlano;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerificaCoberturaPlanoConsumer {

    private final ConverterKafka converter;
    private final CoberturaPlanoUC coberturaPlanoUC;

    @KafkaListener(topics = "${spring.kafka.consumer.cobertura-plano.topic}",
            groupId = "${spring.kafka.consumer.cobertura-plano.group-id}"    )
    public void consumer(VerificaCoberturaPlano payload,
                         @Header(KafkaHeader.TRANSACTIONID) String transactionId,
                         @Header(KafkaHeader.CORRELATIONID) String correlationId,
                         final Acknowledgment ack) {
        VerificaCoberturaPlanoDto dto = converter.avroToDto(payload);
        coberturaPlanoUC.verification(dto);
        ack.acknowledge();

    }
}
