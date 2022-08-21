package br.com.boasaude.associado.microservicecore.dto;

import br.com.boasaude.associado.microservicecore.enums.EstadoCivil;
import br.com.boasaude.associado.microservicecore.enums.Genero;
import br.com.boasaude.associado.microservicecore.enums.Situacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AssociadoDto {

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

    private PlanoDto planoDto;

    private EnderecoDto enderecoDto;















}
