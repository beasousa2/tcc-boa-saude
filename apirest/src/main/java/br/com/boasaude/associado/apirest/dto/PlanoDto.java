package br.com.boasaude.associado.apirest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlanoDto {

    private String descricao;
    private Boolean odontologico;
    private Boolean enfermaria;
    private Boolean apartamento;
    private BigDecimal precoMensalidade;
}
