package br.com.boasaude.microserviceassociado.adapters.database.repository;

import br.com.boasaude.microserviceassociado.adapters.entities.Consulta;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ConsultaRepository extends MongoRepository<Consulta, String> {

    Optional<Consulta> findByMatricula(String matricula);
}
