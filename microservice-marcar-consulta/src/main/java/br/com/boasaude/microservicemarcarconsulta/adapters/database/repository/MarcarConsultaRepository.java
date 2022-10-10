package br.com.boasaude.microservicemarcarconsulta.adapters.database.repository;

import br.com.boasaude.microservicemarcarconsulta.adapters.database.entity.MarcarConsulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface MarcarConsultaRepository extends JpaRepository<MarcarConsulta, Long> {

    boolean existsByCodigoMedicoAndDataHora(String codigoMedico, LocalDateTime dataHora);
}
