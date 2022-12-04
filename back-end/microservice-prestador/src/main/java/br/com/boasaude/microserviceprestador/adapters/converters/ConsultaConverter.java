package br.com.boasaude.microserviceprestador.adapters.converters;

import br.com.boasaude.microservicemarcarconsulta.marcar_nova_consulta_resposta.MarcarNovaConsultaResposta;
import br.com.boasaude.microserviceprestador.adapters.database.entities.Consulta;
import br.com.boasaude.microserviceprestador.dto.ConsultaDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ConsultaConverter {

    public ConsultaDto converter(MarcarNovaConsultaResposta avro) {
        return ConsultaDto.builder()
                .id(avro.getData().getId())
                .codigoPrestador(avro.getData().getCodigoMedico().toString())
                .dataHora(LocalDateTime.parse(avro.getData().getDataHora()))
                .descricao(avro.getData().getDescricao().toString())
                .matriculaPaciente(avro.getData().getMatriculaPaciente().toString())
                .build();
    }

    public Consulta converter(ConsultaDto dto) {
        return Consulta.builder()
                .idConsulta(dto.getId())
                .idPrestador(dto.getCodigoPrestador())
                .dataHora(dto.getDataHora().minusHours(3))
                .descricao(dto.getDescricao())
                .matriculaPaciente(dto.getMatriculaPaciente())
                .build();
    }


}
