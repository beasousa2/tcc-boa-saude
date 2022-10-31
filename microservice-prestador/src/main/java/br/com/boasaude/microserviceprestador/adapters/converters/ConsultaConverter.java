package br.com.boasaude.microserviceprestador.adapters.converters;

import br.com.boasaude.microservicemarcarconsulta.marcar_nova_consulta_resposta.MarcarNovaConsultaResposta;
import br.com.boasaude.microserviceprestador.adapters.database.entities.Consulta;
import br.com.boasaude.microserviceprestador.dto.ConsultaDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ConsultaConverter {

    public ConsultaDto converter(MarcarNovaConsultaResposta avro) {
        return ConsultaDto.builder()
                .idConsulta(avro.getData().getId())
                .codigoPrestador(avro.getData().getCodigoMedico().toString())
                .dataHora(LocalDateTime.parse(avro.getData().getDataHora()))
                .descricao(avro.getData().getDescricao().toString())
                .matriculaPaciente(avro.getData().getMatriculaPaciente().toString())
                .build();
    }

    public Consulta converter(ConsultaDto dto) {
        return Consulta.builder()
                .idConsulta(dto.getIdConsulta())
                .codigoPrestador(dto.getCodigoPrestador())
                .dataHora(dto.getDataHora())
                .descricao(dto.getDescricao())
                .matriculaPaciente(dto.getMatriculaPaciente())
                .build();
    }


}
