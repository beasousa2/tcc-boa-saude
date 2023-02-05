package br.com.boasaude.microservicemarcarconsulta.usecase.impl;


import br.com.boasaude.microservicemarcarconsulta.adapters.api.form.NovaConsultaForm;
import br.com.boasaude.microservicemarcarconsulta.adapters.database.converters.DatabaseConverter;
import br.com.boasaude.microservicemarcarconsulta.adapters.database.entity.Consulta;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.producers.VerificaDebitosProducer;
import br.com.boasaude.microservicemarcarconsulta.dto.CoberturaPlanoReplyDto;
import br.com.boasaude.microservicemarcarconsulta.dto.CoberturaPlanoRequestDto;
import br.com.boasaude.microservicemarcarconsulta.dto.TodasConsultasDto;
import br.com.boasaude.microservicemarcarconsulta.port.interfaces.ConsultaPort;
import br.com.boasaude.microservicemarcarconsulta.usecase.interfaces.CoberturaPlanoUC;
import br.com.boasaude.microservicemarcarconsulta.usecase.interfaces.ConsultaUC;
import br.com.boasaude.microservicemarcarconsulta.usecase.interfaces.PagamentosUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ConsultaUCImpl implements ConsultaUC {

    private final ConsultaPort port;

    private final PagamentosUC pagamentosUC;
    private final CoberturaPlanoUC planoUC;
    private final DatabaseConverter converter;

    private final VerificaDebitosProducer producer;


    @Override
    public TodasConsultasDto execute() {
        List<Consulta> consultas = port.execute();
        return converter.converter(consultas);
    }

    @Override
    public void execute(CoberturaPlanoReplyDto dto) {
        Consulta consulta = converter.dtoToEntity(dto);
        Consulta consultaMarcada = port.execute(consulta);
        pagamentosUC.execute(consultaMarcada);
    }

    @Override
    public void execute(NovaConsultaForm form) {
        CoberturaPlanoRequestDto planoRequestDto = converter.formToDto(form);
        planoUC.consultaCoberturaPlano(planoRequestDto);
    }
}
