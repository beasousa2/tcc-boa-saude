package br.com.boasaude.orquestrador.usecase.interfaces;


import br.com.boasaude.microservicemarcarconsulta.verifica_debito_request.VerificaDebito;
import br.com.boasaude.pagamentos.debito_verificado_reply.DebitoVerificadoReply;
import org.springframework.stereotype.Component;

@Component
public interface PagamentosOrquestradorUC {

    void verificarDebitos(VerificaDebito payload);

    void debitoVerificado(DebitoVerificadoReply payload);
}
