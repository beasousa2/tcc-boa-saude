package br.com.boasaude.microservicemarcarconsulta.adapters.database.converters;

import br.com.boasaude.microservicemarcarconsulta.adapters.api.form.NovaConsultaForm;
import br.com.boasaude.microservicemarcarconsulta.adapters.database.entity.Consulta;
import br.com.boasaude.microservicemarcarconsulta.dto.CoberturaPlanoReplyDto;
import br.com.boasaude.microservicemarcarconsulta.dto.CoberturaPlanoRequestDto;
import br.com.boasaude.microservicemarcarconsulta.dto.ConsultaDto;
import br.com.boasaude.microservicemarcarconsulta.dto.TodasConsultasDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DatabaseConverter {

    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Consulta dtoToEntity(CoberturaPlanoReplyDto dto) {
        return Consulta.builder()
                .codigoConveniado(dto.getCodigoConveniado())
                .codigoMedico(dto.getCodigoMedico())
                .dataHora(LocalDateTime.parse(dto.getDataHora(), format))
                .matriculaPaciente(dto.getMatricula())
                .codigoPaciente(dto.getAssociadoId())
                .descricao(dto.getDescricao())
                .procedimento(dto.getProcedimento())
                .concluida(Boolean.FALSE)
                .build();
    }

    public CoberturaPlanoRequestDto formToDto(NovaConsultaForm form) {
        return CoberturaPlanoRequestDto.builder()
                .associadoId(form.getCodigoAssociado())
                .planoId(form.getPlanoId())
                .procedimento(form.getProcedimento())
                .codigoConveniado(form.getCodigoConveniado())
                .codigoMedico(form.getCodigoMedico())
                .matricula(form.getMatricula())
                .dataHora(form.getDataHora())
                .descricao(form.getDescricao())
                .build();
    }

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
