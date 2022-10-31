package br.com.boasaude.microserviceassociado.usecase.interfaces;

import br.com.boasaude.microserviceassociado.dto.CriaAssociadoDto;

public interface CriarNovoAssociadoUC {

    String execute(CriaAssociadoDto dto);
}
