package br.com.boasaude.microserviceprestador.api.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FormacaoForm {

    @NotEmpty
    @NotNull
    private String curso;
    @NotEmpty
    @NotNull
    private String anoInicio;
    @NotEmpty
    @NotNull
    private String anoConclusao;
    @NotEmpty
    @NotNull
    private String instituicao;
    @NotEmpty
    @NotNull
    private String tipoFormacao;
}
