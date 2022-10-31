package br.com.boasaude.microserviceprestador.usecase.interfaces;

import br.com.boasaude.microserviceprestador.dto.ConsultaDto;
import org.springframework.stereotype.Component;

@Component
public interface ConsultaUC {

    void execute(ConsultaDto consultaDto);
}
