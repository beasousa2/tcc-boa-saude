package br.com.boasaude.microserviceassociado.adapters.database.converter;

import br.com.boasaude.microserviceassociado.adapters.entities.Consulta;
import br.com.boasaude.microserviceassociado.api.form.ConsultaForm;
import br.com.boasaude.microserviceassociado.dto.ConsultaDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ConsultaConverterDatabase {

    public Consulta converter(ConsultaDto dto) {
        return Consulta.builder()
                .idConsultaMarcada(dto.getId())
                .codigoConveniado(dto.getCodigoConveniado())
                .codigoMedico(dto.getCodigoMedico())
                .codigoPaciente(dto.getCodigoPaciente())
                .matricula(dto.getMatriculaPaciente())
                .dataHora(dto.getDataHora())
                .descricao(dto.getDescricao())
                .build();
    }

    public ConsultaDto converter(Consulta consulta) {
        return ConsultaDto.builder()
                .id(consulta.getIdConsultaMarcada())
                .codigoConveniado(consulta.getCodigoConveniado())
                .codigoMedico(consulta.getCodigoMedico())
                .codigoPaciente(consulta.getCodigoPaciente())
                .dataHora(consulta.getDataHora())
                .descricao(consulta.getDescricao())
                .matriculaPaciente(consulta.getMatricula())
                .build();
    }
}
