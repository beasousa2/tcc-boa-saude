package br.com.boasaude.apirest.port.interfaces;

import br.com.boasaude.apirest.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.apirest.dto.AssociadoDto;

public interface NovoAssociadoCriadoPort {
    void execute(AssociadoDto dto, KafkaHeaderDto kafkaHeaderDto);
}
