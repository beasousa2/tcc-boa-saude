package br.com.boasaude.microserviceassociado.ports.interfaces;

import br.com.boasaude.microserviceassociado.adapters.entities.Consulta;
import org.springframework.stereotype.Component;

@Component
public interface MarcarConsultaPort {

    void execute(Consulta consulta);
}
