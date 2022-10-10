package br.com.boasaude.microservicemarcarconsulta.usecase.interfaces;

import br.com.boasaude.microservicemarcarconsulta.adapters.api.form.NovaConsultaForm;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microservicemarcarconsulta.dto.MarcarNovaConsultaDto;

public interface MarcarNovaConsultaUC {
    void execute(NovaConsultaForm form);

}
