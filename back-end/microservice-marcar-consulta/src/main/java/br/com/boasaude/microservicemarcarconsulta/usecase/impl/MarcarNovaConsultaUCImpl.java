package br.com.boasaude.microservicemarcarconsulta.usecase.impl;

import br.com.boasaude.microservicemarcarconsulta.adapters.api.form.NovaConsultaForm;
import br.com.boasaude.microservicemarcarconsulta.adapters.database.entity.Consulta;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.converters.MarcarNovaConsultaConverter;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.producers.MarcarNovaConsultaProducer;
import br.com.boasaude.microservicemarcarconsulta.marcar_nova_consulta_resposta.MarcarNovaConsultaResposta;
import br.com.boasaude.microservicemarcarconsulta.port.interfaces.MarcarNovaConsultaPort;
import br.com.boasaude.microservicemarcarconsulta.usecase.interfaces.MarcarNovaConsultaUC;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor

public class MarcarNovaConsultaUCImpl implements MarcarNovaConsultaUC {

    private final MarcarNovaConsultaPort port;
    private final MarcarNovaConsultaConverter converter;
    private final MarcarNovaConsultaProducer producer;

    private String transactionId = UUID.randomUUID().toString();
    private String correlationId = UUID.randomUUID().toString();
    @Value("${spring.kafka.producer.marcar-consulta.topic}")
    private String topico;

    @Override
    public void execute(NovaConsultaForm form) {
        KafkaHeaderDto headers = KafkaHeader.retrieveHeader(transactionId, topico, correlationId, "Nova Consulta");
        Consulta marcarConsulta = converter.formToEntity(form);
        Consulta consulta = port.execute(marcarConsulta);
        System.out.println("Consulta: " + consulta.getDataHora()
        );
        MarcarNovaConsultaResposta avro = converter.entityToAvro(consulta);
        System.out.println("Avro:" + avro.getData().getDataHora());
        producer.producerSuccess(avro, headers);
    }
}
