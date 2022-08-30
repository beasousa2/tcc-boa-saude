package br.com.boasaude.microserviceconveniado.adapters.database.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "tipo_procedimento")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TipoProcedimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(name = "tipo", nullable = false)
    private String tipo;
}
