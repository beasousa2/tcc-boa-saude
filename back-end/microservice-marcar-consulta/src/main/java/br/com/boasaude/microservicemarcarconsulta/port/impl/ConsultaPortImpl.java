package br.com.boasaude.microservicemarcarconsulta.port.impl;

import br.com.boasaude.microservicemarcarconsulta.adapters.database.entity.Consulta;
import br.com.boasaude.microservicemarcarconsulta.adapters.database.repository.ConsultaRepository;
import br.com.boasaude.microservicemarcarconsulta.exceptions.ConsultaExistenteException;
import br.com.boasaude.microservicemarcarconsulta.port.interfaces.ConsultaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ConsultaPortImpl implements ConsultaPort {

    private final ConsultaRepository repository;
    @Override
    public List<Consulta> execute() {
        return repository.findAll();
    }

    @Override
    public Consulta execute(Consulta consulta) {

        if(repository.existsByCodigoMedicoAndDataHora(consulta.getCodigoMedico(), consulta.getDataHora())) {
            throw new ConsultaExistenteException("Horário indisponível");
        }

        return repository.save(consulta);

    }
}
