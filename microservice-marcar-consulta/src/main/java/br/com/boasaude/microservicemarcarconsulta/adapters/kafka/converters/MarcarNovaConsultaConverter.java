package br.com.boasaude.microservicemarcarconsulta.adapters.kafka.converters;

import br.com.boasaude.microservicemarcarconsulta.adapters.api.form.NovaConsultaForm;
import br.com.boasaude.microservicemarcarconsulta.adapters.database.entity.MarcarConsulta;
import br.com.boasaude.microservicemarcarconsulta.marcar_nova_consulta_resposta.MarcarNovaConsultaResposta;
import br.com.boasaude.microservicemarcarconsulta.marcar_nova_consulta_resposta.MarcarNovaConsultaRespostaData;
import org.springframework.stereotype.Component;

@Component
public class MarcarNovaConsultaConverter {

    public MarcarConsulta formToEntity(NovaConsultaForm form) {

        return MarcarConsulta.builder()
                .codigoConveniado(form.getCodigoConveniado())
                .codigoMedico(form.getCodigoMedico())
                .dataHora(form.getDataHora())
                .matriculaPaciente(form.getMatricula())
                .descricao(form.getDescricao())
                .concluida(Boolean.FALSE)
                .build();
    }

    public MarcarNovaConsultaResposta entityToAvro(MarcarConsulta consulta) {

        return MarcarNovaConsultaResposta.newBuilder()
                .setData(MarcarNovaConsultaRespostaData.newBuilder()
                        .setCodigoConveniado(consulta.getCodigoConveniado())
                        .setCodigoMedico(consulta.getCodigoMedico())
                        .setDataHora(consulta.getDataHora().toString())
                        .setMatriculaPaciente(consulta.getMatriculaPaciente())
                        .setId(consulta.getId())
                        .build())
                .build();
    }
}
