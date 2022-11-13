package br.com.boasaude.microserviceprestador.dto.prestador;

import br.com.boasaude.microserviceprestador.enums.TipoDocumento;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DadosPrestadorDto {

    private String id;
    private String nome;
    private TipoDocumento tipoDocumento;
    private String documento;
}
