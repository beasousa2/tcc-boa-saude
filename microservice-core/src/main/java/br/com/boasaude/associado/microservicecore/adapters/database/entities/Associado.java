package br.com.boasaude.associado.microservicecore.adapters.database.entities;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "associado")
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Associado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Column(name = "cpf", nullable = false)
    private String cpf;
    @Column(name = "rg", nullable = false)
    private String rg;
    @Column(name = "orgao_emissor", nullable = false)
    private String orgaoEmissor;
    @Column(name = "data_emissao")
    private LocalDate dataEmissao;
    @Column(name = "matricula", nullable = false)
    private String matricula;
    @Column(name = "telefone", nullable = false)
    private String telefone;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "estado_civil", nullable = false)
    private String estadoCivil;
    @Column(name = "genero", nullable = false)
    private String genero;
    @Column(name = "situacao", nullable = false)
    private String situacao;


    @OneToOne(cascade = CascadeType.PERSIST)
    private Plano plano;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Endereco endereco;

    @Deprecated
    public Associado(){}

    public Associado(String nome, LocalDate dataNascimento, String cpf, String rg, String orgaoEmissor,
                     LocalDate dataEmissao, String matricula, String telefone, String email, String estadoCivil,
                     String genero, String situacao, Plano plano, Endereco endereco) {

        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.orgaoEmissor = orgaoEmissor;
        this.dataEmissao = dataEmissao;
        this.matricula = matricula;
        this.telefone = telefone;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.genero = genero;
        this.situacao = situacao;
        this.plano = plano;
        this.endereco = endereco;
    }


}
