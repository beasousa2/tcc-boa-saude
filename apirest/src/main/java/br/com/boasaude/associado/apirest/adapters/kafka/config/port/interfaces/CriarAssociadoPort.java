package br.com.boasaude.associado.apirest.adapters.kafka.config.port.interfaces;

import br.com.boasaude.associado.apirest.dto.AssociadoDto;

public interface CriarAssociadoPort {

    void execute(AssociadoDto associadoDto);
}
