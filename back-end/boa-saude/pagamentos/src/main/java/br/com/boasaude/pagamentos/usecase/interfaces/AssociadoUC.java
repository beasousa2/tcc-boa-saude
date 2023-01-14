package br.com.boasaude.pagamentos.usecase.interfaces;

import br.com.boasaude.pagamentos.dto.DebitoAssociadoVerificadoDTO;
import br.com.boasaude.pagamentos.dto.VerificarDebitoAssociadoDTO;
import org.springframework.stereotype.Component;

@Component
public interface AssociadoUC {

    void verificarDebitos(VerificarDebitoAssociadoDTO dto);
}
