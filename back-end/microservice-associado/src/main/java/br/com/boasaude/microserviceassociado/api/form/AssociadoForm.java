package br.com.boasaude.microserviceassociado.api.form;

import br.com.boasaude.microserviceassociado.enums.Situacao;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class AssociadoForm {

    @NotEmpty
    @NotNull
    @Size(min=5)
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    @NotEmpty
    private String cpf;
    @NotNull
    @NotEmpty
    @Size(max=8)
    private String rg;
    @NotNull
    @NotEmpty
    private String orgaoEmissor;
    @NotNull
    private LocalDate dataEmissao;
    @NotNull
    @NotEmpty
    private String telefone;
    @NotNull
    @NotEmpty
    @Email
    private String email;
    @NotNull
    @NotEmpty
    private Situacao situacao;

    @NotNull
    @NotEmpty
    private String estadoCivil;
    @NotNull
    @NotEmpty
    private String genero;

    private String matricula ;
    private PlanoForm plano;
    private EnderecoForm endereco;
}
