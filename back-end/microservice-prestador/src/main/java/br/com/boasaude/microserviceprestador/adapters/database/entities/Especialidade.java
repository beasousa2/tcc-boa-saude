package br.com.boasaude.microserviceprestador.adapters.database.entities;

import br.com.boasaude.microserviceprestador.enums.TipoEspecialidade;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "especialidade_data")
@Builder
@Getter
public class Especialidade {


    private String nomeEspecialidade;
    private TipoEspecialidade tipo;
}
