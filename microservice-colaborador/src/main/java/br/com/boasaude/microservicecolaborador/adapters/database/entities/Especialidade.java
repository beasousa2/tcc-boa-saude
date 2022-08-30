package br.com.boasaude.microservicecolaborador.adapters.database.entities;

import br.com.boasaude.microservicecolaborador.enums.TipoEspecialidade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "especialidade")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "nomeEspecialidade", nullable = false)
    private String nomeEspecialidade;

    @Column(name = "tipo", nullable = false)
    private TipoEspecialidade tipo;
}
