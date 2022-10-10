package br.com.boasaude.apirest.dto.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class PlanoForm {

    @NotNull
    @NotEmpty
    private String descricao;
    @NotNull
    private Boolean odontologico;
    @NotNull
    private Boolean enfermaria;
    @NotNull
    private Boolean apartamento;
    @NotNull
    private BigDecimal precoMensalidade;
}
