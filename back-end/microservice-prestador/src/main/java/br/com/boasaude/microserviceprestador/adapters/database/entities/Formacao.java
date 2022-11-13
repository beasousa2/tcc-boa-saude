package br.com.boasaude.microserviceprestador.adapters.database.entities;

import br.com.boasaude.microserviceprestador.enums.TipoFormacao;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "formacao_data")
@Builder
@Getter
public class Formacao {

    @Id
    private String id;
    private String curso;
    private String anoInicio;
    private String anoConclusao;
    private String instituicao;
    private TipoFormacao tipoFormacao;
}
