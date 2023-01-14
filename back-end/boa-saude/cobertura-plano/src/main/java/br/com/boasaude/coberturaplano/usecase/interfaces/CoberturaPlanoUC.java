package br.com.boasaude.coberturaplano.usecase.interfaces;

import br.com.boasaude.coberturaplano.dto.VerificaCoberturaPlanoDto;
import org.springframework.stereotype.Component;

@Component
public interface CoberturaPlanoUC {

    void verification(VerificaCoberturaPlanoDto dto);

}
