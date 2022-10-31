package br.com.boasaude.microserviceassociado.adapters.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document(collection = "associado_data")
@Builder
@Getter
public class Associado {

    @Id
    private String id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String rg;
    private String orgaoEmissor;
    private LocalDate dataEmissao;
    private String matricula;
    private String telefone;
    private String email;
    private String estadoCivil;
    private String genero;
    private String situacao;
    private String descricao;
    private Boolean odontologico;
    private Boolean enfermaria;
    private Boolean apartamento;
    private BigDecimal precoMensalidade;
    private String logradouro;
    private String cep;
    private String complemento;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;

}
