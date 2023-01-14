package br.com.boasaude.microserviceassociado.adapters.database.repository;

import br.com.boasaude.microserviceassociado.adapters.database.entities.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
