package br.com.boasaude.microservicemarcarconsulta.port.interfaces;


import br.com.boasaude.microservicemarcarconsulta.adapters.database.entity.Consulta;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ConsultaPort {

    List<Consulta> execute();
}
