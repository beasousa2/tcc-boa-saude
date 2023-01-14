package br.com.boasaude.coberturaplano.ports.interfaces;

import br.com.boasaude.coberturaplano.dto.CoberturaPlanoVerificadoDTO;
import br.com.boasaude.coberturaplano.dto.VerificaCoberturaPlanoDto;
import org.springframework.stereotype.Component;

@Component
public interface CoberturaPlanoPort {

    CoberturaPlanoVerificadoDTO verificar(VerificaCoberturaPlanoDto dto);
}
