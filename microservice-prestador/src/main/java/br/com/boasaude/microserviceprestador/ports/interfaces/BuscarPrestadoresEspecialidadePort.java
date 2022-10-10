package br.com.boasaude.microserviceprestador.ports.interfaces;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Prestador;

import java.util.List;

public interface BuscarPrestadoresEspecialidadePort {
    List<Prestador> execute (String nomeEspecialidade);
}
