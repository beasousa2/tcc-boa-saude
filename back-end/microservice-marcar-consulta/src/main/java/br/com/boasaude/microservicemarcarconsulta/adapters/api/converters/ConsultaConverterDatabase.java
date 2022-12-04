package br.com.boasaude.microservicemarcarconsulta.adapters.api.converters;

import br.com.boasaude.microservicemarcarconsulta.adapters.database.entity.Consulta;
import br.com.boasaude.microservicemarcarconsulta.dto.ConsultaDto;
import br.com.boasaude.microservicemarcarconsulta.dto.TodasConsultasDto;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConsultaConverterDatabase {

    public TodasConsultasDto converter(List<Consulta> consultas) {
        return TodasConsultasDto.builder()
                .consultas(consultas.stream()
                        .map(consulta -> ConsultaDto.builder()
                                .id(consulta.getId())
                                .codigoMedico(consulta.getCodigoMedico())
                                .dataHora(consulta.getDataHora())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
