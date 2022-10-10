package br.com.boasaude.apirest.usecases.interfaces;

import br.com.boasaude.apirest.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.apirest.dto.AssociadoDto;

public interface NovoAssociadoCriadoUC {
    void execute(AssociadoDto dto, KafkaHeaderDto kafkaHeaderDto);
}
