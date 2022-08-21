package br.com.boasaude.associado.microservicecore.adapters.database.entities;

import lombok.*;
import org.apache.kafka.common.protocol.types.Field;

import javax.persistence.*;

@Entity(name = "endereco")
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;
    @Column(name = "cep", nullable = false)
    private String cep;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "numero", nullable = false)
    private String numero;
    @Column(name = "bairro", nullable = false)
    private String bairro;
    @Column(name = "cidade", nullable = false)
    private String cidade;
    @Column(name = "uf", nullable = false)
    private String uf;
    @Deprecated
    public Endereco(){}

    public Endereco(String logradouro, String cep, String complemento, String numero,
                    String bairro, String cidade, String uf){

        this.logradouro = logradouro;
        this.cep = cep;
        this.complemento = complemento;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;

    }
}
