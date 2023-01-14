package br.com.boasaude.pagamentos.adapters.database.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Pagamentos {

    private Long id;
    private LocalDate dataVencimento;
    private Boolean isPago;
}
