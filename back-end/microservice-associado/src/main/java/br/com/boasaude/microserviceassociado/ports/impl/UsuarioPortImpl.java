package br.com.boasaude.microserviceassociado.ports.impl;

import br.com.boasaude.microserviceassociado.adapters.database.entities.Usuario;
import br.com.boasaude.microserviceassociado.adapters.database.repository.UsuarioRepository;
import br.com.boasaude.microserviceassociado.dto.UsuarioDto;
import br.com.boasaude.microserviceassociado.ports.interfaces.UsuarioPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioPortImpl implements UsuarioPort {

    private final UsuarioRepository repository;

    @Override
    public Usuario execute(Usuario usuario) {
        return repository.save(usuario);
    }
}
