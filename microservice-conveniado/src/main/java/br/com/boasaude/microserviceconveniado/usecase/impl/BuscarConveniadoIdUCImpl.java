package br.com.boasaude.microserviceconveniado.usecase.impl;

import br.com.boasaude.microserviceconveniado.adapters.database.entities.Conveniado;
import br.com.boasaude.microserviceconveniado.adapters.kafka.converter.BuscarConveniadoIdConverter;
import br.com.boasaude.microserviceconveniado.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceconveniado.adapters.kafka.producer.BuscarConveniadoIdProducer;
import br.com.boasaude.microserviceconveniado.buscar_conveniado_id_resposta.BuscarConveniadoIdResposta;
import br.com.boasaude.microserviceconveniado.dto.BuscarConveniadoIdDto;
import br.com.boasaude.microserviceconveniado.dto.conveniado.ConveniadoDto;
import br.com.boasaude.microserviceconveniado.ports.interfaces.BuscarConveniadoIdPort;
import br.com.boasaude.microserviceconveniado.usecase.interfaces.BuscarConveniadoIdUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BuscarConveniadoIdUCImpl implements BuscarConveniadoIdUC {

    private final BuscarConveniadoIdPort port;
    private final BuscarConveniadoIdProducer producer;
    private final BuscarConveniadoIdConverter converter;

    @Override
    public void execute(BuscarConveniadoIdDto dto, KafkaHeaderDto kafkaHeaderDto) {
        Optional<Conveniado> conveniado = port.execute(dto.getIdConveniado());
        ConveniadoDto conveniadoDto = converter.enityToDto(conveniado);
        BuscarConveniadoIdResposta avro = converter.dtoToAvro(conveniadoDto);
        producer.producerSuccess(avro, kafkaHeaderDto);


    }


}
