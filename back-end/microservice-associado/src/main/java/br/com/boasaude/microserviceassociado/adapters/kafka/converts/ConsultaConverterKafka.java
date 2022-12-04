package br.com.boasaude.microserviceassociado.adapters.kafka.converts;

import br.com.boasaude.microserviceassociado.dto.ConsultaDto;
import br.com.boasaude.microservicemarcarconsulta.marcar_nova_consulta_resposta.MarcarNovaConsultaResposta;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ConsultaConverterKafka {


    public ConsultaDto converter(MarcarNovaConsultaResposta avro) {

        return ConsultaDto.builder()
                .id(avro.getData().getId())
                .codigoConveniado(avro.getData().getCodigoConveniado().toString())
                .codigoMedico(avro.getData().getCodigoMedico().toString())
                .dataHora(LocalDateTime.parse(avro.getData().getDataHora()))
                .descricao(avro.getData().getDescricao().toString())
                .matriculaPaciente(avro.getData().getMatriculaPaciente().toString())
                .build();
    }
}
