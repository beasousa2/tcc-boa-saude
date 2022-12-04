package br.com.boasaude.microserviceassociado.adapters.api.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EnderecoForm {

    @NotNull
    @NotEmpty
    private String logradouro;
    @NotNull
    @NotEmpty
    private String cep;
    @NotNull
    @NotEmpty
    private String numero;
    private String complemento;
    @NotNull
    @NotEmpty
    private String bairro;
    @NotNull
    @NotEmpty
    private String cidade;
    @NotNull
    @NotEmpty
    private String uf;
}
