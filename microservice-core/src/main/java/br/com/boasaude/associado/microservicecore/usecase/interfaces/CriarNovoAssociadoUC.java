package br.com.boasaude.associado.microservicecore.usecase.interfaces;

import br.com.boasaude.associado.microservicecore.dto.AssociadoDto;

public interface CriarNovoAssociadoUC {

    void execute(AssociadoDto dto);
}
