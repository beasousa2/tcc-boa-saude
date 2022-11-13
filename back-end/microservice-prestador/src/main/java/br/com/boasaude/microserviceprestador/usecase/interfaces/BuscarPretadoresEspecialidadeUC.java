package br.com.boasaude.microserviceprestador.usecase.interfaces;

import br.com.boasaude.microserviceprestador.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceprestador.dto.BuscarPrestadoresEspecialidadeDto;
import br.com.boasaude.microserviceprestador.dto.BuscarPrestadoresEspecialidadeRespostaDto;

public interface BuscarPretadoresEspecialidadeUC {

    void executeProducer(BuscarPrestadoresEspecialidadeDto dto, KafkaHeaderDto kafkaHeaderDto);

    BuscarPrestadoresEspecialidadeRespostaDto executeController(String especialidade);
}
