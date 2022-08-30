package br.com.boasaude.microserviceconveniado.adapters.database.repository;


import br.com.boasaude.microserviceconveniado.adapters.database.entities.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
}
