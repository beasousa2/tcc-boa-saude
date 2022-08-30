package br.com.boasaude.microserviceconveniado.adapters.database.repository;

import br.com.boasaude.microserviceconveniado.adapters.database.entities.TipoProcedimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoProcedimentoRepository extends JpaRepository<TipoProcedimento, Long> {
}
