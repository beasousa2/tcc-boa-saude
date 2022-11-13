package br.com.boasaude.microserviceprestador.ports.impl;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Prestador;
import br.com.boasaude.microserviceprestador.adapters.database.repository.PrestadorRepository;
import br.com.boasaude.microserviceprestador.ports.interfaces.CriarPrestadorPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CriarPrestadorPortImpl implements CriarPrestadorPort {

    private final PrestadorRepository repository;
    @Override
    public void execute(Prestador prestador) {
        repository.save(prestador);
    }
}
