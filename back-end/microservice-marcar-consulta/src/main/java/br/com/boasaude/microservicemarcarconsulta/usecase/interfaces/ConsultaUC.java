package br.com.boasaude.microservicemarcarconsulta.usecase.interfaces;

import br.com.boasaude.microservicemarcarconsulta.dto.TodasConsultasDto;
import org.springframework.stereotype.Component;

@Component
public interface ConsultaUC {

    TodasConsultasDto execute();
}
