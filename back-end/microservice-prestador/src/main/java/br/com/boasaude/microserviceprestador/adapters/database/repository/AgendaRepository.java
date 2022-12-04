package br.com.boasaude.microserviceprestador.adapters.database.repository;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Agenda;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgendaRepository extends MongoRepository<Agenda, String> {
}
