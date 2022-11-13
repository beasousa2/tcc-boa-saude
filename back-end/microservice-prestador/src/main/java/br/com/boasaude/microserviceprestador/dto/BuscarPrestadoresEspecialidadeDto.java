package br.com.boasaude.microserviceprestador.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BuscarPrestadoresEspecialidadeDto {

    private String nomeEspecialidade;
}
