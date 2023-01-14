package br.com.boasaude.microserviceassociado.usecase.interfaces;

import br.com.boasaude.microserviceassociado.dto.ConsultaDto;
import br.com.boasaude.microserviceassociado.dto.ConsultasDto;
import org.springframework.stereotype.Component;

@Component
public interface ConsultaUC {

    void novaConsulta(ConsultaDto consultaDto);
    ConsultasDto getConsultasByAssociado(String id);
    ConsultaDto getConsulta(Long idConsultaMarcada);


}
