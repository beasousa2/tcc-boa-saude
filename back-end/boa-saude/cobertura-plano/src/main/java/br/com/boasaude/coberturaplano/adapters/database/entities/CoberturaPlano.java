package br.com.boasaude.coberturaplano.adapters.database.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
public class CoberturaPlano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String associadoId;
    private Boolean isAssociadoAtivo;
    private Long planoId;
    @ManyToMany
    private List<Cobertura> cobertura;
}
