package br.com.boasaude.microservicemarcarconsulta.adapters.database.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity(name = "marcar_consulta")
@Data
@Builder
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(name = "dataHora", nullable = false, unique = true)
    private LocalDateTime dataHora;

    @Column(name = "matricula_paciente", nullable = false)
    private String matriculaPaciente;

    @Column(name = "codigo_paciente", nullable = false)
    private String codigoPaciente;

    @Column(name = "codigo_medico")
    private String codigoMedico;

    @Column(name = "codigo_conveniado")
    private String codigoConveniado;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "procedimento", nullable = false)
    private String procedimento;

    @Column(name = "concluida", nullable = false)
    private Boolean concluida;


}
