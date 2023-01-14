package br.com.boasaude.pagamentos.adapters.database.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
public class Associado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String codigoAssociado;
    private String codigoMatricula;
    @ManyToMany
    private List<Pagamentos> pagamentos;
}
