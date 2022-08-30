package br.com.boasaude.microserviceconveniado.adapters.database.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "especialidade_conveniado")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadeConveniado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(name = "especialidade", nullable = false)
    private String especialidade;
}
