package br.com.boasaude.microserviceconveniado.ports.interfaces;

import br.com.boasaude.microserviceconveniado.dto.conveniado.ConveniadoDto;

public interface RetornoConveniadoPort {

    void execute(ConveniadoDto dto);
}
