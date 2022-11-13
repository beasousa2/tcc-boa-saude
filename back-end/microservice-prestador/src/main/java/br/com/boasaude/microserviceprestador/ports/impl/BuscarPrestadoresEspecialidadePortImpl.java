package br.com.boasaude.microserviceprestador.ports.impl;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Prestador;
import br.com.boasaude.microserviceprestador.adapters.database.repository.PrestadorRepository;
import br.com.boasaude.microserviceprestador.ports.interfaces.BuscarPrestadoresEspecialidadePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarPrestadoresEspecialidadePortImpl implements BuscarPrestadoresEspecialidadePort {

    private final PrestadorRepository repository;

    @Override
    public List<Prestador> execute(String nomeEspecialidade) {

        return repository.findByEspecialidades(nomeEspecialidade);
    }
}
