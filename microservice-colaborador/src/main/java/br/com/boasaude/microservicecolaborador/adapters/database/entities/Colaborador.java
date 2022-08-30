package br.com.boasaude.microservicecolaborador.adapters.database.entities;

import br.com.boasaude.microservicecolaborador.enums.TipoDocumento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "colaborador")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Formacao> formacoes;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Especialidade> especialidades;

    @Column(name = "tipoDocumento", nullable = false)
    private TipoDocumento tipoDocumento;

    @Column(name = "documento", nullable = false)
    private String documento;



}
