package br.com.boasaude.microservicemarcarconsulta.adapters.database.repository;

import br.com.boasaude.microservicemarcarconsulta.adapters.database.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    boolean existsByCodigoMedicoAndDataHora(String codigoMedico, LocalDateTime dataHora);
}
