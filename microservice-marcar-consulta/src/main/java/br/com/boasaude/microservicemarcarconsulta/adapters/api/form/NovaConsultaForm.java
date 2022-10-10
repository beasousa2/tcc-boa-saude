package br.com.boasaude.microservicemarcarconsulta.adapters.api.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class NovaConsultaForm {

    @NotNull
    private String matricula;
    private String codigoMedico;
    private String documento;
    private String codigoConveniado;
    @NotNull
    private LocalDateTime dataHora;
    @NotNull
    private String descricao;


}
