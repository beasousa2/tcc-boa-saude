package br.com.boasaude.microserviceprestador.usecase.impl;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Agenda;
import br.com.boasaude.microserviceprestador.adapters.converters.AgendaConverter;
import br.com.boasaude.microserviceprestador.adapters.api.form.AgendaForm;
import br.com.boasaude.microserviceprestador.ports.interfaces.AgendaPort;
import br.com.boasaude.microserviceprestador.usecase.interfaces.AgendaUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AgendaUCImpl implements AgendaUC {

    private final AgendaConverter converter;
    private final AgendaPort port;
    @Override
    public void execute(AgendaForm form) {
        Agenda agenda = converter.formToEntity(form);
        port.execute(agenda);
    }
}
