package br.com.boasaude.microservicemarcarconsulta.usecase.interfaces;

import br.com.boasaude.microservicemarcarconsulta.adapters.api.form.NovaConsultaForm;
import br.com.boasaude.microservicemarcarconsulta.dto.CoberturaPlanoReplyDto;
import br.com.boasaude.microservicemarcarconsulta.dto.TodasConsultasDto;
import org.springframework.stereotype.Component;

@Component
public interface ConsultaUC {

    TodasConsultasDto execute();
    void execute(CoberturaPlanoReplyDto dto);
    void execute(NovaConsultaForm form);
}
