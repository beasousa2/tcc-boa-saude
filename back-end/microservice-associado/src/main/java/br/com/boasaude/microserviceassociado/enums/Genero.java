package br.com.boasaude.microserviceassociado.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Genero {

    FEMININO("FEMININO"),
    MASCULINO("MASCULINO");

    private String name;
}
