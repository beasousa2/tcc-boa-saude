package br.com.boasaude.microserviceassociado.adapters.database.converter;

import br.com.boasaude.microserviceassociado.adapters.database.entities.Usuario;
import br.com.boasaude.microserviceassociado.dto.UsuarioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioConverter {



    public Usuario converter(UsuarioDto dto) {

        return Usuario.builder()
                .username(dto.getUsername())
                .perfil(dto.getPerfil())
                .password(dto.getPassword())
                .build();
    }
}
