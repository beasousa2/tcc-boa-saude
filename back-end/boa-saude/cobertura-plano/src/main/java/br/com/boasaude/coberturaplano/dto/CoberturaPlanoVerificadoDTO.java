package br.com.boasaude.coberturaplano.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoberturaPlanoVerificadoDTO {

    private String associadoId;
    private Long planoId;
    private Boolean isCoberto;
}
