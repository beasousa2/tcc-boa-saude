package br.com.boasaude.microserviceassociado.dto;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AssociadoDTO {

    private InformacoesPessoaisDto infoPessoaisDto;

    private PlanoDto planoDto;

    private EnderecoDto enderecoDto;

}
