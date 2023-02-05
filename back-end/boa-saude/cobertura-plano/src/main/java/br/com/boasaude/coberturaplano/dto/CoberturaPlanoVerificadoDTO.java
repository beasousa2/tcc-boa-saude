package br.com.boasaude.coberturaplano.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoberturaPlanoVerificadoDTO {

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
