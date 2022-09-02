package br.com.boasaude.microserviceconveniado.adapters.database.entities;

import br.com.boasaude.microserviceconveniado.enums.TipoConveniado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "especialidade")
@Builder
@Getter
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(name = "especialidade", nullable = false)
    private String especialidade;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TipoConveniado> tipoConveniados;
}
