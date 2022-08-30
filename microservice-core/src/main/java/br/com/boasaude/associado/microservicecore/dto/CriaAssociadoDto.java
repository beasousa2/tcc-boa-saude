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
public class CriaAssociadoDto {

    private InformacoesPessoaisDto infoPessoaisDto;

    private PlanoDto planoDto;

    private EnderecoDto enderecoDto;















}
