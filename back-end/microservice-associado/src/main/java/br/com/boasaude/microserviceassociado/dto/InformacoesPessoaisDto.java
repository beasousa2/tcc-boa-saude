package br.com.boasaude.microserviceassociado.dto;


import br.com.boasaude.microserviceassociado.enums.EstadoCivil;
import br.com.boasaude.microserviceassociado.enums.Genero;
import br.com.boasaude.microserviceassociado.enums.Situacao;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
public class InformacoesPessoaisDto {

    private String id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String rg;
    private String orgaoEmissor;
    private LocalDate dataEmissao;
    private String telefone;
    private String email;
    private Situacao situacao;
    private EstadoCivil estadoCivil;
    private Genero genero;
    private String matricula;
}
