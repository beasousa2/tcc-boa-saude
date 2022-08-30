package br.com.boasaude.associado.microservicecore.dto;


import br.com.boasaude.associado.microservicecore.enums.EstadoCivil;
import br.com.boasaude.associado.microservicecore.enums.Genero;
import br.com.boasaude.associado.microservicecore.enums.Situacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InformacoesPessoaisDto {

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
