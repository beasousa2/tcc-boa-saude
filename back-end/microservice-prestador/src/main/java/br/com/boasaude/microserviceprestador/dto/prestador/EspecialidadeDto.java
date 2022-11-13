package br.com.boasaude.microserviceprestador.dto.prestador;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EspecialidadeDto {

    private Long id;
    private String nomeEspecialidade;
}
