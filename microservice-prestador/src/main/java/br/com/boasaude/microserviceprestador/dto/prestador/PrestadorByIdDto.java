package br.com.boasaude.microserviceprestador.dto.prestador;

import br.com.boasaude.microserviceprestador.enums.TipoDocumento;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PrestadorByIdDto {

    private String id;
    private String nomeCompleto;
    private String telefone;
    private EnderecoDto endereco;
    private TipoDocumento tipoDocumento;
    private String documento;

}
