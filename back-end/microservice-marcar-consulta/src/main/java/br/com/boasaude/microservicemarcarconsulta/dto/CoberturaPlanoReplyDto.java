package br.com.boasaude.microservicemarcarconsulta.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoberturaPlanoReplyDto {

    private String associadoId;
    private Long planoId;
    private String matricula;
    private String dataHora;
    private String codigoMedico;
    private String codigoConveniado;
    private String descricao;
    private String procedimento;
    private Boolean isCoberto;
}
