package br.com.boasaude.microserviceassociado.adapters.database.converter;

import br.com.boasaude.microserviceassociado.adapters.database.entities.Consulta;
import br.com.boasaude.microserviceassociado.dto.ConsultaDto;
import br.com.boasaude.microserviceassociado.dto.ConsultasDto;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConsultaConverter {

    public Consulta converter(ConsultaDto dto) {
        return Consulta.builder()
                .idConsultaMarcada(dto.getId())
                .codigoConveniado(dto.getCodigoConveniado())
                .codigoMedico(dto.getCodigoMedico())
                .matricula(dto.getMatriculaPaciente())
                .dataHora(dto.getDataHora().minusHours(3))
                .descricao(dto.getDescricao())
                .build();
    }

    public ConsultaDto converter(Consulta consulta) {
        return ConsultaDto.builder()
                .id(consulta.getIdConsultaMarcada())
                .codigoConveniado(consulta.getCodigoConveniado())
                .codigoMedico(consulta.getCodigoMedico())
                .dataHora(consulta.getDataHora().plusHours(3))
                .descricao(consulta.getDescricao())
                .matriculaPaciente(consulta.getMatricula())
                .build();
    }

    public ConsultasDto converter(List<Consulta> consultas) {
        return ConsultasDto.builder()
                .consultas(consultas.stream().map(consulta -> ConsultaDto.builder()
                        .matriculaPaciente(consulta.getMatricula())
                        .codigoMedico(consulta.getCodigoMedico())
                        .codigoConveniado(consulta.getCodigoConveniado())
                        .dataHora(consulta.getDataHora().plusHours(3))
                        .descricao(consulta.getDescricao())
                        .id(consulta.getIdConsultaMarcada())
                        .build()).collect(Collectors.toList()))

                .build();
    }
}
