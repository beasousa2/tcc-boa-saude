package br.com.boasaude.microserviceassociado.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
public class CriaAssociadoDto {

    private InformacoesPessoaisDto infoPessoaisDto;

    private PlanoDto planoDto;

    private EnderecoDto enderecoDto;















}
