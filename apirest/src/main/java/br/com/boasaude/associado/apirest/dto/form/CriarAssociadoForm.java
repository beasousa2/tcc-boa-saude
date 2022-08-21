package br.com.boasaude.associado.apirest.dto.form;

import br.com.boasaude.associado.apirest.dto.AssociadoDto;
import br.com.boasaude.associado.apirest.dto.EnderecoDto;
import br.com.boasaude.associado.apirest.dto.PlanoDto;
import br.com.boasaude.associado.apirest.enums.EstadoCivil;
import br.com.boasaude.associado.apirest.enums.Genero;
import br.com.boasaude.associado.apirest.enums.Situacao;
import br.com.boasaude.associado.apirest.enums.UF;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class CriarAssociadoForm {

    @NotEmpty
    @NotNull
    @Size(min=5)
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    @NotEmpty
    @CPF
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

    private Situacao situacao;

    @NotNull
    @NotEmpty
    private String estadoCivil;
    @NotNull
    @NotEmpty
    private String genero;

    private String matricula;
    private PlanoForm plano;
    private EnderecoForm endereco;

    public AssociadoDto formToDto() {
        return AssociadoDto.builder()
                .cpf(cpf)
                .dataEmissao(dataEmissao)
                .dataNascimento(dataNascimento)
                .email(email)
                .endereco(EnderecoDto.builder()
                        .logradouro(endereco.getLogradouro())
                        .cep(endereco.getCep())
                        .numero(endereco.getNumero())
                        .bairro(endereco.getBairro())
                        .cidade(endereco.getCidade())
                        .uf(UF.valueOf(endereco.getUf()))
                        .build())
                .estadoCivil(EstadoCivil.valueOf(estadoCivil))
                .genero(Genero.valueOf(genero))
                .situacao(Situacao.ATIVO)
                .nome(nome)
                .rg(rg)
                .orgaoEmissor(orgaoEmissor)
                .plano(PlanoDto.builder()
                        .descricao(plano.getDescricao())
                        .apartamento(plano.getApartamento())
                        .enfermaria(plano.getEnfermaria())
                        .odontologico(plano.getOdontologico())
                        .precoMensalidade(plano.getPrecoMensalidade())
                        .build())
                .telefone(telefone)
                .build();
    }
}
