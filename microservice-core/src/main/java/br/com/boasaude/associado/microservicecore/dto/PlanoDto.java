package br.com.boasaude.associado.microservicecore.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
@Builder
public class PlanoDto {

    private String descricao;
    private Boolean odontologico;
    private Boolean enfermaria;
    private Boolean apartamento;
    private BigDecimal precoMensalidade;
}
