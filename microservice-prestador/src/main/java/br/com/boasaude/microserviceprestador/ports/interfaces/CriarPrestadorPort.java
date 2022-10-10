package br.com.boasaude.microserviceprestador.ports.interfaces;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Prestador;

public interface CriarPrestadorPort {

    void execute(Prestador prestador);

}
