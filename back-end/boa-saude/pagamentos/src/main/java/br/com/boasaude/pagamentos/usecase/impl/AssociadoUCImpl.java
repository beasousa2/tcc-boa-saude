package br.com.boasaude.pagamentos.usecase.impl;

import br.com.boasaude.pagamentos.adapters.kafka.converter.ConverterKafka;
import br.com.boasaude.pagamentos.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.pagamentos.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.pagamentos.adapters.kafka.producer.DebitoVerificadoProducer;
import br.com.boasaude.pagamentos.debito_verificado_reply.DebitoVerificadoReply;
import br.com.boasaude.pagamentos.dto.DebitoAssociadoVerificadoDTO;
import br.com.boasaude.pagamentos.dto.VerificarDebitoAssociadoDTO;
import br.com.boasaude.pagamentos.ports.interfaces.AssociadoPort;
import br.com.boasaude.pagamentos.usecase.interfaces.AssociadoUC;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AssociadoUCImpl implements AssociadoUC {

    private final AssociadoPort port;
    private final DebitoVerificadoProducer producer;
    private final ConverterKafka converter;
    @Value("spring.kafka.producer.pagamentos.topic")
    private String topico;
    private final String transactionId = UUID.randomUUID().toString();
    private final String correlationId = UUID.randomUUID().toString();

    @Override
    public void verificarDebitos(VerificarDebitoAssociadoDTO dto) {
        KafkaHeaderDto headerDto = KafkaHeader.retrieveHeader(transactionId, correlationId, topico, "Verifica Débitos Associado");
        DebitoAssociadoVerificadoDTO verificadoDTO;
        verificadoDTO = port.verificarDebitos(dto.getCodigoAssociado(), false);
        final DebitoVerificadoReply avro = converter.dtoToAvro(verificadoDTO);
        producer.producerSuccess(avro, headerDto);
    }
}
