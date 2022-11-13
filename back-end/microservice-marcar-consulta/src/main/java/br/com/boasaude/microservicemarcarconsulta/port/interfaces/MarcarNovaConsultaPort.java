package br.com.boasaude.microservicemarcarconsulta.port.interfaces;

import br.com.boasaude.microservicemarcarconsulta.adapters.database.entity.Consulta;

public interface MarcarNovaConsultaPort {

    Consulta execute(Consulta consulta);

}
