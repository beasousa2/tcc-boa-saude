package br.com.boasaude.pagamentos.adapters.database.repository;

import br.com.boasaude.pagamentos.adapters.database.entities.Associado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociadoRepository extends JpaRepository<Long, Associado> {

    Associado findByCodigoAssociadoAndPagamentosIsPago(String codigoAssociado, Boolean isPago);
}
