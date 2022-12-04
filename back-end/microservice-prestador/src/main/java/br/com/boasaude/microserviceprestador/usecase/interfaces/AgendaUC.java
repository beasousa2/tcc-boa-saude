package br.com.boasaude.microserviceprestador.usecase.interfaces;

import br.com.boasaude.microserviceprestador.adapters.api.form.AgendaForm;
import org.springframework.stereotype.Component;

@Component
public interface AgendaUC {

    void execute(AgendaForm form);
}
