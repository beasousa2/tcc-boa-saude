package br.com.boasaude.microserviceassociado.ports.interfaces;

import br.com.boasaude.microserviceassociado.adapters.database.entities.Usuario;
import br.com.boasaude.microserviceassociado.dto.UsuarioDto;
import org.springframework.stereotype.Component;

@Component
public interface UsuarioPort {

    Usuario execute(Usuario usuario);
}
