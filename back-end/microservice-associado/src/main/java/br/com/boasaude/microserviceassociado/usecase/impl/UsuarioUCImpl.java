package br.com.boasaude.microserviceassociado.usecase.impl;

import br.com.boasaude.microserviceassociado.adapters.api.form.LoginForm;
import br.com.boasaude.microserviceassociado.adapters.database.converter.UsuarioConverter;
import br.com.boasaude.microserviceassociado.adapters.database.entities.Usuario;
import br.com.boasaude.microserviceassociado.dto.UsuarioDto;
import br.com.boasaude.microserviceassociado.ports.interfaces.UsuarioPort;
import br.com.boasaude.microserviceassociado.usecase.interfaces.UsuarioUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioUCImpl implements UsuarioUC {

    private final UsuarioConverter converter;
    private final UsuarioPort port;

    @Override
    public void execute(UsuarioDto dto) {
        Usuario usuario = converter.converter(dto);
        port.execute(usuario);
    }

    @Override
    public void execute(LoginForm loginForm) {

    }
}
