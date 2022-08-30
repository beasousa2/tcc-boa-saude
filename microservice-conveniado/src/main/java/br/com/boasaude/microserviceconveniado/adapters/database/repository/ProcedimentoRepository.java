package br.com.boasaude.microserviceconveniado.adapters.database.repository;

import br.com.boasaude.microserviceconveniado.adapters.database.entities.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long> {
}
