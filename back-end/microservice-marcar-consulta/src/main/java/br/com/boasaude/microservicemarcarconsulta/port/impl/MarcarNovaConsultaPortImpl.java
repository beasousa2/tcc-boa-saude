package br.com.boasaude.microservicemarcarconsulta.port.impl;

import br.com.boasaude.microservicemarcarconsulta.adapters.database.entity.Consulta;
import br.com.boasaude.microservicemarcarconsulta.adapters.database.repository.ConsultaRepository;
import br.com.boasaude.microservicemarcarconsulta.exceptions.ConsultaExistenteException;
import br.com.boasaude.microservicemarcarconsulta.port.interfaces.MarcarNovaConsultaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MarcarNovaConsultaPortImpl implements MarcarNovaConsultaPort {

    private final ConsultaRepository repository;

    @Override
    public Consulta execute(Consulta consulta) {

        if(repository.existsByCodigoMedicoAndDataHora(consulta.getCodigoMedico(), consulta.getDataHora())) {
            throw new ConsultaExistenteException("Horário indisponível");
        }

        return repository.save(consulta);


    }
}
