package br.com.boasaude.microserviceassociado.adapters.database.entities;

import br.com.boasaude.microserviceassociado.enums.Perfil;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "associado_user")
@Data
@Builder
public class Usuario {

    @Id
    private String id;
    private String username;
    private String password;
    private Perfil perfil;
}
