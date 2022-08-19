package br.com.boasaude.associado.microservicecore.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoCivil {
    SOLTEIRO("SOLTEIRO"),
    CASADO("CASADO"),
    SEPARADO("SEPARADO"),
    DIVORCIADO("DIVORCIADO"),
    UNIAO_ESTAVEL("UNIAO_ESTAVEL"),
    VIUVO("VIUVO")
    ;

    private String descricao;
}
