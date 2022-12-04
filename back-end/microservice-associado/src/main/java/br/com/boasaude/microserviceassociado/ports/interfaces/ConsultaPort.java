package br.com.boasaude.microserviceassociado.ports.interfaces;

import br.com.boasaude.microserviceassociado.adapters.database.entities.Consulta;
import br.com.boasaude.microserviceassociado.dto.ConsultaDto;
import br.com.boasaude.microserviceassociado.dto.ConsultasDto;
import org.springframework.stereotype.Component;

@Component
public interface ConsultaPort {

    void execute(Consulta consulta);
    ConsultasDto execute(String matricula);

    ConsultaDto execute(Long idConsulta);
}
