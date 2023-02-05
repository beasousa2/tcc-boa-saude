package br.com.boasaude.microservicemarcarconsulta.usecase.interfaces;

import br.com.boasaude.microservicemarcarconsulta.adapters.database.entity.Consulta;
import org.springframework.stereotype.Component;

@Component
public interface PagamentosUC {

    void execute(Consulta consulta);
}
