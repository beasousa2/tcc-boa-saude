package br.com.boasaude.orquestrador.usecase.interfaces;
import br.com.boasaude.microservicemarcarconsulta.verifica_cobertura_plano_request.VerificaCoberturaPlano;

import org.springframework.stereotype.Component;

@Component
public interface CoberturaPlanoOrquestradorUC {

    void execute(VerificaCoberturaPlano avro);

}
