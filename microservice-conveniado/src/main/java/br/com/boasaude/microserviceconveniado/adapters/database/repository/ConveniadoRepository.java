package br.com.boasaude.microserviceconveniado.adapters.database.repository;

import br.com.boasaude.microserviceconveniado.adapters.database.entities.Conveniado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConveniadoRepository extends JpaRepository<Conveniado, Long> {

    List<Conveniado> findByEspecialidades(String especialidade);
}
