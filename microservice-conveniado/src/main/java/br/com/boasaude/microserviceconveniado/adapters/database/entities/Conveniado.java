package br.com.boasaude.microserviceconveniado.adapters.database.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "conveniado")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Conveniado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(name = "razaoSocial", nullable = false)
    private String razaoSocial;

    @Column(name = "nomeFantasia", nullable = false)
    private String nomeFantasia;

    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Procedimento> procedimentos;

    @OneToOne
    private EspecialidadeConveniado especialidadeConveniado;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;


}
