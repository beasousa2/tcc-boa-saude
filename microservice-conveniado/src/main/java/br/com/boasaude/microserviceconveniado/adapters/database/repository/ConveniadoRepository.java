package br.com.boasaude.microserviceconveniado.adapters.database.repository;

import br.com.boasaude.microserviceconveniado.adapters.database.entities.Conveniado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConveniadoRepository extends JpaRepository<Conveniado, Long> {
}
