package br.com.boasaude.microserviceassociado.usecase.impl;

import br.com.boasaude.microserviceassociado.adapters.database.converter.ConsultaConverter;
import br.com.boasaude.microserviceassociado.adapters.database.entities.Consulta;
import br.com.boasaude.microserviceassociado.dto.ConsultaDto;
import br.com.boasaude.microserviceassociado.dto.ConsultasDto;
import br.com.boasaude.microserviceassociado.ports.interfaces.ConsultaPort;
import br.com.boasaude.microserviceassociado.usecase.interfaces.ConsultaUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsultaUCImpl implements ConsultaUC {

    private final ConsultaConverter converter;
    private final ConsultaPort port;
    @Override
    public void novaConsulta(ConsultaDto consultaDto) {
        Consulta consulta = converter.converter(consultaDto);
        port.execute(consulta);
    }

    @Override
    public ConsultasDto getConsultasByAssociado(String matricula) {
        return port.execute(matricula);
    }

    @Override
    public ConsultaDto getConsulta(Long idConsultaMarcada) {
        return port.execute(idConsultaMarcada);
    }
}
