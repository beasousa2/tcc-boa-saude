package br.com.boasaude.microserviceprestador.dto.prestador;

import br.com.boasaude.microserviceprestador.enums.TipoFormacao;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FormacaoDto {

    private Long id;
    private String curso;
    private String anoInicio;
    private String anoConclusao;
    private String instituicao;
    private TipoFormacao tipoFormacao;
}
