package br.com.boasaude.microserviceprestador.usecase.impl;

import br.com.boasaude.microserviceprestador.adapters.converters.ConsultaConverter;
import br.com.boasaude.microserviceprestador.adapters.database.entities.Consulta;
import br.com.boasaude.microserviceprestador.dto.ConsultaDto;
import br.com.boasaude.microserviceprestador.ports.interfaces.ConsultaPort;
import br.com.boasaude.microserviceprestador.usecase.interfaces.ConsultaUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsultaUCImpl implements ConsultaUC {

    private final ConsultaPort port;
    private final ConsultaConverter converter;

    @Override
    public void execute(ConsultaDto consultaDto) {
        Consulta consulta = converter.converter(consultaDto);
        System.out.println("Consulta (USECASE): " + consulta.getDataHora());
        port.execute(consulta);
    }
}
