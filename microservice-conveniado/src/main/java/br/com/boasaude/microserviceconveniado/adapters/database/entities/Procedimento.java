package br.com.boasaude.microserviceconveniado.adapters.database.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "procedimento")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Procedimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private Long id;

    @OneToOne
    private TipoProcedimento tipoprocedimento;

    @Column(name = "nome", nullable = false)
    private String nomeProcedimento;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Especialidade> especialidade;
}
