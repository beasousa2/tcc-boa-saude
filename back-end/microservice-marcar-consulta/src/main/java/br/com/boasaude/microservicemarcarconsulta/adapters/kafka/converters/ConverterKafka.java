package br.com.boasaude.microservicemarcarconsulta.adapters.kafka.converters;

import br.com.boasaude.coberturaplano.cobertura_plano_verificado_reply.CoberturaPlanoVerificado;
import br.com.boasaude.microservicemarcarconsulta.adapters.database.entity.Consulta;
import br.com.boasaude.microservicemarcarconsulta.dto.CoberturaPlanoReplyDto;
import br.com.boasaude.microservicemarcarconsulta.dto.CoberturaPlanoRequestDto;
import br.com.boasaude.microservicemarcarconsulta.marcar_nova_consulta_resposta.MarcarNovaConsultaResposta;
import br.com.boasaude.microservicemarcarconsulta.marcar_nova_consulta_resposta.MarcarNovaConsultaRespostaData;
import br.com.boasaude.microservicemarcarconsulta.verifica_cobertura_plano_request.VerificaCoberturaPlano;
import br.com.boasaude.microservicemarcarconsulta.verifica_cobertura_plano_request.VerificaCoberturaPlanoData;
import br.com.boasaude.microservicemarcarconsulta.verifica_debito_request.VerificaDebito;
import br.com.boasaude.microservicemarcarconsulta.verifica_debito_request.VerificaDebitoData;
import org.springframework.stereotype.Component;

@Component
public class ConverterKafka {


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

    public VerificaCoberturaPlano dtoToAvro(CoberturaPlanoRequestDto dto) {
        return VerificaCoberturaPlano.newBuilder()
                .setData(VerificaCoberturaPlanoData.newBuilder()
                        .setAssociadoId(dto.getAssociadoId())
                        .setPlanoId(dto.getPlanoId())
                        .setProcedimento(dto.getProcedimento())
                        .setCodigoMedico(dto.getCodigoMedico())
                        .setCodigoConveniado(dto.getCodigoConveniado())
                        .setProcedimento(dto.getProcedimento())
                        .setDataHora(dto.getDataHora())
                        .setDescricao(dto.getDescricao())
                        .build())
                .build();
    }

    public CoberturaPlanoReplyDto avroToDto(CoberturaPlanoVerificado payload) {
        return CoberturaPlanoReplyDto.builder()
                .associadoId(payload.getData().getAssociadoId().toString())
                .isCoberto(payload.getData().getIsCoberto())
                .planoId(payload.getData().getPlanoId())
                .codigoConveniado(payload.getData().getCodigoConveniado().toString())
                .codigoMedico(payload.getData().getCodigoMedico().toString())
                .matricula(payload.getData().getMatricula().toString())
                .dataHora(payload.getData().getDataHora().toString())
                .descricao(payload.getData().getDescricao().toString())
                .procedimento(payload.getData().getProcedimento().toString())
                .build();
    }

    public VerificaDebito verificaDebito(Consulta consulta) {
        return VerificaDebito.newBuilder()
                .setData(VerificaDebitoData.newBuilder()
                        .setCodigoAssociado(consulta.getCodigoPaciente())
                        .setCodigoConsulta(consulta.getId())
                        .build())
                .build();
    }
}
