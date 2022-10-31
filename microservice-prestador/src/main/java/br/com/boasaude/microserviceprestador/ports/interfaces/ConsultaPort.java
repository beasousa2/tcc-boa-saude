package br.com.boasaude.microserviceprestador.ports.interfaces;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Consulta;
import org.springframework.stereotype.Component;

@Component
public interface ConsultaPort {

    void execute(Consulta consulta);
}
