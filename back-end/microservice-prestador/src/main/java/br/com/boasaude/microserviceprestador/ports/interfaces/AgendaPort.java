package br.com.boasaude.microserviceprestador.ports.interfaces;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Agenda;
import org.springframework.stereotype.Component;

@Component
public interface AgendaPort {

    void execute(Agenda agenda);
}
