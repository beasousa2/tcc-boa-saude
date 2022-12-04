package br.com.boasaude.microserviceassociado.adapters.database.repository;

import br.com.boasaude.microserviceassociado.adapters.database.entities.Associado;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AssociadoRepository extends MongoRepository<Associado, String> {

    Optional<Associado> findByMatricula(String matricula);
}
