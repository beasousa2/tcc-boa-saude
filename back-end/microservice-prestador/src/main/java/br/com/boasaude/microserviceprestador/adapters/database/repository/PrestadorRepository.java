package br.com.boasaude.microserviceprestador.adapters.database.repository;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Prestador;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PrestadorRepository extends MongoRepository<Prestador, String> {

    List<Prestador> findAllByEspecialidadesNomeEspecialidadeAndCidade(String especialidade, String cidade);
}
