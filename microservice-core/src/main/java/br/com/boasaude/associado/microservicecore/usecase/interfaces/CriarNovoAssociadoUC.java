package br.com.boasaude.associado.microservicecore.usecase.interfaces;

import br.com.boasaude.associado.microservicecore.dto.CriaAssociadoDto;

public interface CriarNovoAssociadoUC {

    void execute(CriaAssociadoDto dto);
}
