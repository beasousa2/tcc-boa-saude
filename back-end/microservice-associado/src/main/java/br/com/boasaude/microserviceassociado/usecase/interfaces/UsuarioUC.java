package br.com.boasaude.microserviceassociado.usecase.interfaces;

import br.com.boasaude.microserviceassociado.adapters.api.form.LoginForm;
import br.com.boasaude.microserviceassociado.adapters.database.entities.Usuario;
import br.com.boasaude.microserviceassociado.dto.UsuarioDto;
import org.springframework.stereotype.Component;

@Component
public interface UsuarioUC {

    void execute(UsuarioDto dto);

    void execute(LoginForm loginForm);
}
