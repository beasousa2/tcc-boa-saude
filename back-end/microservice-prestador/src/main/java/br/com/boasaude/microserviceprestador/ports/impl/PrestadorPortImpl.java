package br.com.boasaude.microserviceprestador.ports.impl;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Prestador;
import br.com.boasaude.microserviceprestador.adapters.database.repository.PrestadorRepository;
import br.com.boasaude.microserviceprestador.ports.interfaces.PrestadorPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PrestadorPortImpl implements PrestadorPort {

    private final PrestadorRepository repository;

    @Override
    public Optional<Prestador> execute(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Prestador> execute(String nomeEspecialidade, String cidade) {

        return repository.findAllByEspecialidadesNomeEspecialidadeAndCidade(nomeEspecialidade, cidade);
    }

    @Override
    public void execute(Prestador prestador) {
        repository.save(prestador);
    }
}

