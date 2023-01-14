package br.com.boasaude.pagamentos.adapters.kafka.consumer;

import br.com.boasaude.microservicemarcarconsulta.verifica_debito_request.VerificaDebito;
import br.com.boasaude.pagamentos.adapters.kafka.converter.ConverterKafka;
import br.com.boasaude.pagamentos.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.pagamentos.dto.VerificarDebitoAssociadoDTO;
import br.com.boasaude.pagamentos.usecase.interfaces.AssociadoUC;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerificaDebitoConsumer {

    private final ConverterKafka converter;
    private final AssociadoUC associadoUC;

    @KafkaListener(topics = "${spring.kafka.consumer.pagamentos.topic}",
            groupId = "${spring.kafka.consumer.pagamentos.group-id}"    )
    public void consumer(VerificaDebito payload,
                         @Header(KafkaHeader.TRANSACTIONID) String transactionId,
                         @Header(KafkaHeader.CORRELATIONID) String correlationId,
                         final Acknowledgment ack) {
        VerificarDebitoAssociadoDTO dto = converter.avroToDto(payload);
        associadoUC.verificarDebitos(dto);
        ack.acknowledge();

    }

}
