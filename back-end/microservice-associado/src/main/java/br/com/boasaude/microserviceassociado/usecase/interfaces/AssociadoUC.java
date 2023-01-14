package br.com.boasaude.microserviceassociado.usecase.interfaces;

import br.com.boasaude.microserviceassociado.adapters.api.form.AssociadoForm;
import br.com.boasaude.microserviceassociado.dto.AssociadoDTO;
import br.com.boasaude.microserviceassociado.dto.DadosAssociadoDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AssociadoUC {

    AssociadoDTO getAssociadoCompleto(String id);
    DadosAssociadoDto getAssociado(String id);
    String salvar(AssociadoForm form);
    List<DadosAssociadoDto> getTodosAssociados();

}
