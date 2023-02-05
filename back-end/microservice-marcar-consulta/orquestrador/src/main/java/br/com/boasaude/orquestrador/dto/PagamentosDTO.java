package br.com.boasaude.orquestrador.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PagamentosDTO {

    private LocalDate dataVencimento;
    private Boolean isPago;
}
