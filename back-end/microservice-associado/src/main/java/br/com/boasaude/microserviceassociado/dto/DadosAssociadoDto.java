package br.com.boasaude.microserviceassociado.dto;

import br.com.boasaude.microserviceassociado.enums.Situacao;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DadosAssociadoDto {

    private String id;
    private String nome;
    private String email;
    private String matricula;
    private Situacao status;
}
