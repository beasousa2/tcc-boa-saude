package br.com.boasaude.associado.apirest.adapters.kafka.config.port.impl;

import br.com.boasaude.associado.apirest.adapters.kafka.converter.CriarAssociadoConverter;
import br.com.boasaude.associado.apirest.adapters.kafka.producers.CriarAssociadoProducer;
import br.com.boasaude.associado.apirest.dto.KafkaHeaderDto;
import br.com.boasaude.associado.apirest.adapters.kafka.config.port.interfaces.CriarAssociadoPort;
import br.com.boasaude.associado.apirest.dto.form.CriarAssociadoForm;
import br.com.boasaude.associado.criar_associado_novo_realizada.CriaAssociadoNovoRealizada;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CriarAssociadoPortImpl implements CriarAssociadoPort {


    private final CriarAssociadoProducer producer;
    private final CriarAssociadoConverter converter;
    @Value("${spring.kafka.producer.criar.topic}")
    private String topic;
    private String correlationId = UUID.randomUUID().toString();
    private String transactionId = UUID.randomUUID().toString();



    @Override
    public void execute(CriarAssociadoForm form) {
        CriaAssociadoNovoRealizada avro = converter.dtoToAvro(form);
        KafkaHeaderDto kafkaDto = KafkaHeaderDto.builder()
                .fluxo("CRIAR_NOVO_ASSOCIADO")
                .topico(topic)
                .correlationId(correlationId)
                .transactionId(transactionId)
                .build();

        producer.producerSuccess(avro, kafkaDto);
        System.out.println("TransactionID: " + transactionId);

    }
}
