package br.com.boasaude.microservicemarcarconsulta.port.interfaces;

import br.com.boasaude.microservicemarcarconsulta.adapters.database.entity.MarcarConsulta;

public interface MarcarNovaConsultaPort {

    MarcarConsulta execute(MarcarConsulta marcarConsulta);

}
