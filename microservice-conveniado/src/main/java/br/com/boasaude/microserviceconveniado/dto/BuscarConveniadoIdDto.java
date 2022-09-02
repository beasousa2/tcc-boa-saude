package br.com.boasaude.microserviceconveniado.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BuscarConveniadoIdDto {

    private Long idConveniado;
}
