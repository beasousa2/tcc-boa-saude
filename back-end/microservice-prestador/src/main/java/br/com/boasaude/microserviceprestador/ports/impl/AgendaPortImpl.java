package br.com.boasaude.microserviceprestador.ports.impl;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Agenda;
import br.com.boasaude.microserviceprestador.adapters.database.repository.AgendaRepository;
import br.com.boasaude.microserviceprestador.ports.interfaces.AgendaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AgendaPortImpl implements AgendaPort {

    private final AgendaRepository repository;
    @Override
    public void execute(Agenda agenda) {
        repository.save(agenda);
    }
}
