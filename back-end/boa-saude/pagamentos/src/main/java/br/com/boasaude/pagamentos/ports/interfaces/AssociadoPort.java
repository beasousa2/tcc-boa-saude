package br.com.boasaude.pagamentos.ports.interfaces;

import br.com.boasaude.pagamentos.dto.DebitoAssociadoVerificadoDTO;
import org.springframework.stereotype.Component;

@Component
public interface AssociadoPort {

    DebitoAssociadoVerificadoDTO verificarDebitos(String codigoAssociado, Boolean isPago);
}
