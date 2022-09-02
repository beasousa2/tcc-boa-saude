package br.com.boasaude.microserviceconveniado.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BuscarConveniadoNomeEspecialidadeDto {

    private String nomeEspecialidade;

}
