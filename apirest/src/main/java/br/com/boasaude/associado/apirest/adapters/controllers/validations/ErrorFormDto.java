package br.com.boasaude.associado.apirest.adapters.controllers.validations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorFormDto {

    private String campo;
    private String erro;
}
