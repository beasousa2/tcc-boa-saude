package br.com.boasaude.orquestrador.adapters.kafka.consumers;


import br.com.boasaude.orquestrador.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.orquestrador.usecase.interfaces.CoberturaPlanoOrquestradorUC;
import br.com.boasaude.microservicemarcarconsulta.verifica_cobertura_plano_request.VerificaCoberturaPlano;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoberturaPlanoConsumer {
    private final CoberturaPlanoOrquestradorUC coberturaPlanoOrquestradorUC;

    @KafkaListener(topics = "${spring.kafka.consumer.cobertura-plano.topic}",
            groupId = "${spring.kafka.consumer.cobertura-plano.group-id}"    )
    public void marcarConsultaConsumer(VerificaCoberturaPlano payload,
                                       @Header(KafkaHeader.TRANSACTIONID) String transactionId,
                                       @Header(KafkaHeader.CORRELATIONID) String correlationId,
                                       final Acknowledgment ack) {
        coberturaPlanoOrquestradorUC.execute(payload);
        ack.acknowledge();
    }


}
