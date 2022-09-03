package br.com.boasaude.microserviceconveniado.ports.impl;

import br.com.boasaude.microserviceconveniado.adapters.database.entities.Conveniado;
import br.com.boasaude.microserviceconveniado.adapters.database.repository.ConveniadoRepository;
import br.com.boasaude.microserviceconveniado.ports.interfaces.BuscarConveniadoIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BuscarConveniadoIdPortImpl implements BuscarConveniadoIdPort {

    private final ConveniadoRepository repository;
    @Override
    public Optional<Conveniado> execute(Long id) {
        return repository.findById(id);
    }
}
