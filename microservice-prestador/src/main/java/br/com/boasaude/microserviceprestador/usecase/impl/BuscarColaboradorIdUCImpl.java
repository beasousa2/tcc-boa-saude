package br.com.boasaude.microserviceprestador.usecase.impl;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Prestador;
import br.com.boasaude.microserviceprestador.adapters.converters.BuscarPrestadorIdConverter;
import br.com.boasaude.microserviceprestador.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceprestador.adapters.kafka.producers.BuscarColaboradorIdProducer;
import br.com.boasaude.microserviceprestador.buscar_prestador_id_resposta.BuscarPrestadorIdResposta;
import br.com.boasaude.microserviceprestador.dto.BuscarPrestadorIdDto;
import br.com.boasaude.microserviceprestador.dto.prestador.PrestadorByIdDto;
import br.com.boasaude.microserviceprestador.ports.interfaces.BuscarPrestadorIdPort;
import br.com.boasaude.microserviceprestador.usecase.interfaces.BuscarPrestadorIdUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BuscarColaboradorIdUCImpl implements BuscarPrestadorIdUC {
    private final BuscarPrestadorIdPort port;
    private final BuscarColaboradorIdProducer producer;
    private final BuscarPrestadorIdConverter converter;

    @Override
    public void executeProducer(BuscarPrestadorIdDto dto, KafkaHeaderDto kafkaHeaderDto) {
        Optional<Prestador> colaborador = port.execute(dto.getId());
        PrestadorByIdDto colaboradorDto = converter.entityToPrestadorIdDto(colaborador.get());
        BuscarPrestadorIdResposta avro = converter.prestadorIdToAvro(colaboradorDto);
        producer.producerSuccess(avro, kafkaHeaderDto);

    }

    @Override
    public PrestadorByIdDto executeController(String id) {
        Optional<Prestador> prestador = port.execute(id);
        return prestador.map(converter::toPrestadorIdDto).orElse(null);
    }
}
