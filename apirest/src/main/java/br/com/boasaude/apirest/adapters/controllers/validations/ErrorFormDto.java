package br.com.boasaude.apirest.adapters.controllers.validations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorFormDto {

    private String campo;
    private String erro;
}
