package br.com.boasaude.microserviceconveniado.dto.conveniado;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EspecialidadeDto {

    private Long id;
    private String especialidade;
}
