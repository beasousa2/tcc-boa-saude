package br.com.boasaude.microservicemarcarconsulta.usecase.interfaces;

import br.com.boasaude.microservicemarcarconsulta.dto.CoberturaPlanoReplyDto;
import br.com.boasaude.microservicemarcarconsulta.dto.CoberturaPlanoRequestDto;
import org.springframework.stereotype.Component;

@Component
public interface CoberturaPlanoUC {

    void consultaCoberturaPlano(CoberturaPlanoRequestDto dto);

    void coberturaPlanoConsultada(CoberturaPlanoReplyDto dto);
}
