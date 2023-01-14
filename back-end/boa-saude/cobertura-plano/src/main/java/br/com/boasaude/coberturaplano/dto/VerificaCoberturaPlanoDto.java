package br.com.boasaude.coberturaplano.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VerificaCoberturaPlanoDto {

    private String associadoId;
    private Long planoId;
    private String procedimento;
}
