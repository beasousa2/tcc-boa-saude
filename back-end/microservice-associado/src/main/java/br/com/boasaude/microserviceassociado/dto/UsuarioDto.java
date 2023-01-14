package br.com.boasaude.microserviceassociado.dto;

import br.com.boasaude.microserviceassociado.enums.Perfil;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDto {

    private String username;
    private String password;
    private Perfil perfil;
}
