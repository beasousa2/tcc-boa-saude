package br.com.boasaude.microserviceprestador.usecase.impl;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Prestador;
import br.com.boasaude.microserviceprestador.adapters.converters.BuscarPrestadoresEspecialidadeConverter;
import br.com.boasaude.microserviceprestador.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceprestador.adapters.kafka.producers.BuscarColaboradoresEspecialidadeProducer;
import br.com.boasaude.microserviceprestador.buscar_prestadores_especialidade_resposta.BuscarPrestadoresEspecialidadeResposta;
import br.com.boasaude.microserviceprestador.dto.BuscarPrestadoresEspecialidadeDto;
import br.com.boasaude.microserviceprestador.dto.BuscarPrestadoresEspecialidadeRespostaDto;
import br.com.boasaude.microserviceprestador.ports.interfaces.BuscarPrestadoresEspecialidadePort;
import br.com.boasaude.microserviceprestador.usecase.interfaces.BuscarPretadoresEspecialidadeUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarColaboradoresEspecialidadeUCImpl implements BuscarPretadoresEspecialidadeUC {

    private final BuscarPrestadoresEspecialidadePort port;
    private final BuscarColaboradoresEspecialidadeProducer producer;
    private final BuscarPrestadoresEspecialidadeConverter converter;

    @Override
    public void executeProducer(BuscarPrestadoresEspecialidadeDto dto, KafkaHeaderDto kafkaHeaderDto) {
        List<Prestador> prestadores = port.execute(dto.getNomeEspecialidade());
        BuscarPrestadoresEspecialidadeRespostaDto prestadoresDto = converter.entityToPrestadoresEspecialidadeDto(prestadores);
        BuscarPrestadoresEspecialidadeResposta avro = converter.dtoToAvro(prestadoresDto);
        producer.producerSuccess(avro, kafkaHeaderDto);

    }

    @Override
    public BuscarPrestadoresEspecialidadeRespostaDto executeController(String especialidade) {
        List<Prestador> prestadores = port.execute(especialidade);
        return converter.entityToPrestadoresEspecialidadeDto(prestadores);
    }
}
