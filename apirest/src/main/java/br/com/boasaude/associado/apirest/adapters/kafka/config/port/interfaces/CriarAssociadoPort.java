package br.com.boasaude.associado.apirest.adapters.kafka.config.port.interfaces;

import br.com.boasaude.associado.apirest.dto.AssociadoDto;
import br.com.boasaude.associado.apirest.dto.form.CriarAssociadoForm;

public interface CriarAssociadoPort {

    void execute(CriarAssociadoForm form);
}
