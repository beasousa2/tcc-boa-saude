package br.com.boasaude.microservicecolaborador.adapters.database.repository;

import br.com.boasaude.microservicecolaborador.adapters.database.entities.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
}
