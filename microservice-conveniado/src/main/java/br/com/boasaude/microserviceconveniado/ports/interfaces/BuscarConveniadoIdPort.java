package br.com.boasaude.microserviceconveniado.ports.interfaces;

import br.com.boasaude.microserviceconveniado.adapters.database.entities.Conveniado;

public interface BuscarConveniadoIdPort {

    Conveniado execute(Long id);
}
