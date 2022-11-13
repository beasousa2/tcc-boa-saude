package br.com.boasaude.microserviceprestador.ports.interfaces;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Prestador;

import java.util.Optional;

public interface BuscarPrestadorIdPort {

    Optional<Prestador> execute(String id);
}
