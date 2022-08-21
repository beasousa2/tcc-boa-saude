package br.com.boasaude.associado.microservicecore.adapters.database.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "Plano")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;
    @Column(name = "odontologico", nullable = false)
    private Boolean odontologico;
    @Column(name = "enfermaria", nullable = false)
    private Boolean enfermaria;
    @Column(name = "apartamento", nullable = false)
    private Boolean apartamento;
    @Column(name = "preco_mensalidade", nullable = false)
    private BigDecimal precoMensalidade;

    @Deprecated
    public Plano() {
    }

    public Plano(String descricao, Boolean odontologico, Boolean enfermaria, Boolean apartamento,
                 BigDecimal precoMensalidade) {
            this.descricao = descricao;
            this.odontologico = odontologico;
            this.enfermaria = enfermaria;
            this.apartamento = apartamento;
            this.precoMensalidade = precoMensalidade;
    }
}
