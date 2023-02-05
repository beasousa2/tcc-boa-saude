package br.com.boasaude.orquestrador.adapters.kafka.consumers;

import br.com.boasaude.microservicemarcarconsulta.verifica_debito_request.VerificaDebito;
import br.com.boasaude.orquestrador.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.orquestrador.usecase.interfaces.PagamentosOrquestradorUC;
import br.com.boasaude.pagamentos.debito_verificado_reply.DebitoVerificadoReply;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PagamentosConsumer {
    private final PagamentosOrquestradorUC pagamentosOrquestradorUC;

    @KafkaListener(topics = "${spring.kafka.consumer.pagamentos.topic}",
            groupId = "${spring.kafka.consumer.pagamentos.group-id}"    )
    public void verificaPagamentos(VerificaDebito payload,
                                   @Header(KafkaHeader.TRANSACTIONID) String transactionId,
                                   @Header(KafkaHeader.CORRELATIONID) String correlationId,
                                   final Acknowledgment ack) {
        pagamentosOrquestradorUC.verificarDebitos(payload);
        ack.acknowledge();

    }

    @KafkaListener(topics = "${spring.kafka.consumer.pagamentos-resposta.topic}",
            groupId = "${spring.kafka.consumer.pagamentos.group-id}"    )
    public void pagamentosVerificados(DebitoVerificadoReply payload,
                                      @Header(KafkaHeader.TRANSACTIONID) String transactionId,
                                      @Header(KafkaHeader.CORRELATIONID) String correlationId,
                                      final Acknowledgment ack) {
        pagamentosOrquestradorUC.debitoVerificado(payload);
        ack.acknowledge();

    }

}
