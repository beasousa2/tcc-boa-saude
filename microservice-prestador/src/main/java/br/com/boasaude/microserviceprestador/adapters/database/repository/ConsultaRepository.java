package br.com.boasaude.microserviceprestador.adapters.database.repository;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Consulta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsultaRepository extends MongoRepository<Consulta, String> {
}
