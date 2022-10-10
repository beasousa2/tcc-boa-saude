package br.com.boasaude.microserviceprestador.adapters.database.entities;

import br.com.boasaude.microserviceprestador.enums.TipoDocumento;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "prestador_data")
@Builder
@Getter
public class Prestador {

    @Id
    private String id;
    private String nomeCompleto;
    private String cpf;
    private String cnpj;
    private String telefone;
    private String email;
    private String logradouro;
    private String cep;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private List<Formacao> formacoes;
    private List<Especialidade> especialidades;
    private TipoDocumento tipoDocumento;
    private String documento;



}
