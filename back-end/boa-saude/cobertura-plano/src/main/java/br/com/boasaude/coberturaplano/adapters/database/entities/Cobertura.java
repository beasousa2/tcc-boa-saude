package br.com.boasaude.coberturaplano.adapters.database.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cobertura {

    private Long id;
    private String descricao;
}
