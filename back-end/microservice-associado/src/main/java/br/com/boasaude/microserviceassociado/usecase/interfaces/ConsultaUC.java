package br.com.boasaude.microserviceassociado.usecase.interfaces;

import br.com.boasaude.microserviceassociado.dto.ConsultaDto;
import br.com.boasaude.microserviceassociado.dto.ConsultasDto;
import org.springframework.stereotype.Component;

@Component
public interface ConsultaUC {

    void execute(ConsultaDto consultaDto);
    ConsultasDto execute(String id);

    ConsultaDto execute(Long idConsultaMarcada);


}
