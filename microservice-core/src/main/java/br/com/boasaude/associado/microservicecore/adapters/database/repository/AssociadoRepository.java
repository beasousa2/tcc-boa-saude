package br.com.boasaude.associado.microservicecore.adapters.database.repository;

import br.com.boasaude.associado.microservicecore.adapters.database.entities.Associado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {
}
