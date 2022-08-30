package br.com.boasaude.microservicecolaborador.adapters.database.entities;

import br.com.boasaude.microservicecolaborador.enums.TipoFormacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "formacao")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Formacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "curso", nullable = false)
    private String curso;

    @Column(name = "anoInicio", nullable = false)
    private String anoInicio;

    @Column(name = "anoConclusao", nullable = false)
    private String anoConclusao;

    @Column(name = "instituicao", nullable = false)
    private String instituicao;

    @Column(name = "tipoFormacao", nullable = false)
    private TipoFormacao tipoFormacao;
}
