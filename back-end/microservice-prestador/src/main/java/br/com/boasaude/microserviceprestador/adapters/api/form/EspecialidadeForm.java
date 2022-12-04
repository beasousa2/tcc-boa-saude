package br.com.boasaude.microserviceprestador.adapters.api.form;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EspecialidadeForm {

    @NotNull
    @NotEmpty
    private String nomeEspecialidade;
    @NotNull
    @NotEmpty
    private String tipo;
}
