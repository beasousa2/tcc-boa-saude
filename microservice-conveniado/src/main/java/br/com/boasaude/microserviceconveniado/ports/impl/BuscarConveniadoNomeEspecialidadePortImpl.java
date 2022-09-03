package br.com.boasaude.microserviceconveniado.ports.impl;

import br.com.boasaude.microserviceconveniado.adapters.database.entities.Conveniado;
import br.com.boasaude.microserviceconveniado.adapters.database.repository.ConveniadoRepository;
import br.com.boasaude.microserviceconveniado.ports.interfaces.BuscarConveniadoNomeEspecialidadePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarConveniadoNomeEspecialidadePortImpl implements BuscarConveniadoNomeEspecialidadePort {

    private final ConveniadoRepository repository;

    @Override
    public List<Conveniado> execute(String nomeEspecialidade) {
        return repository.findByEspecialidades(nomeEspecialidade);
    }
}
