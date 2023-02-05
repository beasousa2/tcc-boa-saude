package br.com.boasaude.orquestrador.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DebitoAssociadoVerificadoDTO {

    private String codigoAssociado;
    private List<PagamentosDTO> pagamentos;
}
