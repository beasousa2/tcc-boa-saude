package br.com.boasaude.microserviceassociado.adapters.database.repository;

import br.com.boasaude.microserviceassociado.adapters.database.entities.Consulta;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ConsultaRepository extends MongoRepository<Consulta, String> {

    Optional<Consulta> findByIdConsultaMarcada(Long idConsulta);

    List<Consulta> findAllByMatricula(String matricula);
}
