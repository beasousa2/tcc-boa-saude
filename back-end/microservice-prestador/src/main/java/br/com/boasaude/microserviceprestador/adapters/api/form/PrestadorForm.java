package br.com.boasaude.microserviceprestador.adapters.api.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class PrestadorForm {

    @NotEmpty
    @NotNull
    @Size(min=5)
    private String nomeCompleto;
    @NotNull
    @NotEmpty
    private String cpf;
    private String cnpj;
    @NotNull
    @NotEmpty
    private String telefone;
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String logradouro;
    @NotNull
    @NotEmpty
    private String cep;
    @NotNull
    @NotEmpty
    private String numero;
    @NotNull
    @NotEmpty
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
    @NotNull
    @NotEmpty
    private String tipoDocumento;
    @NotNull
    @NotEmpty
    private String documento;
    private List<EspecialidadeForm> especialidadeForms;
    private List<FormacaoForm> formacaoForms;
}
