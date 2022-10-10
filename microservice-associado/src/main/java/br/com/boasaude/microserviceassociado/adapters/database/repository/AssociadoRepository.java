package br.com.boasaude.microserviceassociado.adapters.database.repository;

import br.com.boasaude.microserviceassociado.adapters.entities.Associado;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssociadoRepository extends MongoRepository<Associado, String> {
}
