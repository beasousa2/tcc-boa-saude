package br.com.boasaude.associado.microservicecore.ports.interfaces;

import br.com.boasaude.associado.microservicecore.adapters.database.entities.Associado;

public interface SalvarAssociadoBancoPort {

    void execute(Associado associado);
}
