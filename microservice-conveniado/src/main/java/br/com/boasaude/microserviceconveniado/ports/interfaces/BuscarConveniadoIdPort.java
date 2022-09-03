package br.com.boasaude.microserviceconveniado.ports.interfaces;

import br.com.boasaude.microserviceconveniado.adapters.database.entities.Conveniado;

import java.util.Optional;

public interface BuscarConveniadoIdPort {

    Optional<Conveniado> execute(Long id);
}
