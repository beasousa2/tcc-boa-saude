package br.com.boasaude.coberturaplano.adapters.database.repositories;

import br.com.boasaude.coberturaplano.adapters.database.entities.Cobertura;
import br.com.boasaude.coberturaplano.adapters.database.entities.CoberturaPlano;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CoberturaPlanoRepository extends JpaRepository<CoberturaPlano, Long> {


    Optional<CoberturaPlano> findByCoberturaDescricaoAndIsAssociadoAtivo(String associadoId, Cobertura cobertura);
}
