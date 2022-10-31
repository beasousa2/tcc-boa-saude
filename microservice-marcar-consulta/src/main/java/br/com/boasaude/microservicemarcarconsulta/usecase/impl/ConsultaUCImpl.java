package br.com.boasaude.microservicemarcarconsulta.usecase.impl;

import br.com.boasaude.microservicemarcarconsulta.adapters.api.converters.ConsultaConverterDatabase;
import br.com.boasaude.microservicemarcarconsulta.adapters.database.entity.Consulta;
import br.com.boasaude.microservicemarcarconsulta.dto.TodasConsultasDto;
import br.com.boasaude.microservicemarcarconsulta.port.interfaces.ConsultaPort;
import br.com.boasaude.microservicemarcarconsulta.usecase.interfaces.ConsultaUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ConsultaUCImpl implements ConsultaUC {

    private final ConsultaPort port;
    private final ConsultaConverterDatabase converter;

    @Override
    public TodasConsultasDto execute() {
        List<Consulta> consultas = port.execute();
        return converter.converter(consultas);
    }
}
