package br.com.boasaude.microservicemarcarconsulta.adapters.api.form;


import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NovaConsultaForm {

    @NotNull(message = "A matrícula não pode ser vazia")
    @NotEmpty(message = "A matricula não pode ser vazia")
    private String matricula;

    @NotNull(message = "O codigo associado não pode ser vazia")
    @NotEmpty(message = "A codigo associado não pode ser vazia")
    private String codigoAssociado;

    @NotNull(message = "O plano id não pode ser vazia")
    @NotEmpty(message = "O plano id não pode ser vazia")
    private Long planoId;

    private String codigoMedico;

    private String codigoConveniado;

    @NotNull(message = "A data e hora não foram preenchidos")
    @NotEmpty(message = "A data e hora não pode ser vazia")
    private String dataHora;

    @NotNull(message = "Informe uma descrição")
    @Max(value = 50, message = "Limite de caracteres atingido")
    @Min(value = 20, message = "A descrição está muito pequena")
    @NotEmpty(message = "A descrição não pode ser vazia")
    private String descricao;

    @NotNull(message = "O procedimento não pode ser vazia")
    @NotEmpty(message = "O procedimento não pode ser vazia")
    private String procedimento;


}
