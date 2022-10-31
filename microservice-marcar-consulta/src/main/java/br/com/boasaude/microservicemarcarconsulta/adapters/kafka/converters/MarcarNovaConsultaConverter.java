package br.com.boasaude.microservicemarcarconsulta.adapters.kafka.converters;

import br.com.boasaude.microservicemarcarconsulta.adapters.api.form.NovaConsultaForm;
import br.com.boasaude.microservicemarcarconsulta.adapters.database.entity.Consulta;
import br.com.boasaude.microservicemarcarconsulta.marcar_nova_consulta_resposta.MarcarNovaConsultaResposta;
import br.com.boasaude.microservicemarcarconsulta.marcar_nova_consulta_resposta.MarcarNovaConsultaRespostaData;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MarcarNovaConsultaConverter {
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Consulta formToEntity(NovaConsultaForm form) {

        return Consulta.builder()
                .codigoConveniado(form.getCodigoConveniado())
                .codigoMedico(form.getCodigoMedico())
                .dataHora(LocalDateTime.parse(form.getDataHora(), format))
                .matriculaPaciente(form.getMatricula())
                .descricao(form.getDescricao())
                .concluida(Boolean.FALSE)
                .build();
    }

    public MarcarNovaConsultaResposta entityToAvro(Consulta consulta) {

        return MarcarNovaConsultaResposta.newBuilder()
                .setData(MarcarNovaConsultaRespostaData.newBuilder()
                        .setCodigoConveniado(consulta.getCodigoConveniado())
                        .setCodigoMedico(consulta.getCodigoMedico())
                        .setDataHora(consulta.getDataHora().toString())
                        .setMatriculaPaciente(consulta.getMatriculaPaciente())
                        .setDescricao(consulta.getDescricao())
                        .setId(consulta.getId())
                        .build())
                .build();
    }
}
