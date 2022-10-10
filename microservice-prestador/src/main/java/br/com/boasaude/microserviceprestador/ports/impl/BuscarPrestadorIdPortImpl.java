package br.com.boasaude.microserviceprestador.ports.impl;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Prestador;
import br.com.boasaude.microserviceprestador.adapters.database.repository.PrestadorRepository;
import br.com.boasaude.microserviceprestador.ports.interfaces.BuscarPrestadorIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BuscarPrestadorIdPortImpl implements BuscarPrestadorIdPort {

    private final PrestadorRepository repository;

    @Override
    public Optional<Prestador> execute(String id) {
        return repository.findById(id);
    }
}
