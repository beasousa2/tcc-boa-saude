package br.com.boasaude.microserviceassociado.adapters.entities;

import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@Builder
public class Plano {



    private String descricao;
    private Boolean odontologico;
    private Boolean enfermaria;
    private Boolean apartamento;
    private BigDecimal precoMensalidade;




}
