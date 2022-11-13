package br.com.boasaude.microserviceprestador.usecase.interfaces;

import br.com.boasaude.microserviceprestador.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceprestador.dto.BuscarPrestadorIdDto;
import br.com.boasaude.microserviceprestador.dto.prestador.PrestadorByIdDto;

public interface BuscarPrestadorIdUC {

    void executeProducer(BuscarPrestadorIdDto dto, KafkaHeaderDto kafkaHeaderDto);
    PrestadorByIdDto executeController(String id);
}
