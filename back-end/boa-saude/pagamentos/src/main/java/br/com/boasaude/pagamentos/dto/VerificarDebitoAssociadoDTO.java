package br.com.boasaude.pagamentos.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VerificarDebitoAssociadoDTO {

    private String codigoAssociado;
}
