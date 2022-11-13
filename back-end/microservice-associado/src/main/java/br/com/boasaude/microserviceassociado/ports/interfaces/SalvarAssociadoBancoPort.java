package br.com.boasaude.microserviceassociado.ports.interfaces;

import br.com.boasaude.associado.criar_associado_resposta.CriarAssociadoResposta;
import br.com.boasaude.microserviceassociado.adapters.entities.Associado;

public interface SalvarAssociadoBancoPort {

    CriarAssociadoResposta execute(Associado associado);
}
