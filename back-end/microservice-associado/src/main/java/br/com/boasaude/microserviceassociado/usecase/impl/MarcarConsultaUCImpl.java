package br.com.boasaude.microserviceassociado.usecase.impl;

import br.com.boasaude.microserviceassociado.adapters.database.converter.ConsultaConverterDatabase;
import br.com.boasaude.microserviceassociado.adapters.entities.Consulta;
import br.com.boasaude.microserviceassociado.dto.ConsultaDto;
import br.com.boasaude.microserviceassociado.ports.interfaces.MarcarConsultaPort;
import br.com.boasaude.microserviceassociado.usecase.interfaces.MarcarConsultaUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MarcarConsultaUCImpl implements MarcarConsultaUC {

    private final ConsultaConverterDatabase converter;
    private final MarcarConsultaPort port;
    @Override
    public void execute(ConsultaDto consultaDto) {
        Consulta consulta = converter.converter(consultaDto);
        port.execute(consulta);
    }
}
