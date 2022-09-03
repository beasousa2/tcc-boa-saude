package br.com.boasaude.microserviceconveniado.usecase.interfaces;

import br.com.boasaude.microserviceconveniado.adapters.database.entities.Conveniado;
import br.com.boasaude.microserviceconveniado.dto.BuscarConveniadoIdDto;

import java.util.Optional;

public interface BuscarConveniadoIdUC {

    Optional<Conveniado> execute(BuscarConveniadoIdDto dto);
}
