package br.com.boasaude.microserviceassociado.usecase.interfaces;

import br.com.boasaude.microserviceassociado.dto.ConsultaDto;
import org.springframework.stereotype.Component;

@Component
public interface MarcarConsultaUC {

    void execute(ConsultaDto consultaDto);
}
