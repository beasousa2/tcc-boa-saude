package br.com.boasaude.microserviceassociado.adapters.api.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginForm {

    @NotNull(message = "Matricula é obrigatória!")
    private String username;
    @NotNull(message = "Senha é obrigatória!")
    private String password;
}
