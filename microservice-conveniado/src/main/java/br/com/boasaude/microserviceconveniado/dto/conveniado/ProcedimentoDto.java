package br.com.boasaude.microserviceconveniado.dto.conveniado;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProcedimentoDto {

    private Long id;
    private String nomeProcedimento;

}
