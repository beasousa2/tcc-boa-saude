package br.com.boasaude.orquestrador.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VerificaCoberturaPlanoDto {

    private String associadoId;
    private Long planoId;
    private String procedimento;
    private String matricula;
    private String dataHora;
    private String codigoMedico;
    private String codigoConveniado;
    private String descricao;

}
