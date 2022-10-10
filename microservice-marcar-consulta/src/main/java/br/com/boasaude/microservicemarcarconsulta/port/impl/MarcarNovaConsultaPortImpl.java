package br.com.boasaude.microservicemarcarconsulta.port.impl;

import br.com.boasaude.microservicemarcarconsulta.adapters.database.entity.MarcarConsulta;
import br.com.boasaude.microservicemarcarconsulta.adapters.database.repository.MarcarConsultaRepository;
import br.com.boasaude.microservicemarcarconsulta.exceptions.ConsultaExistenteException;
import br.com.boasaude.microservicemarcarconsulta.port.interfaces.MarcarNovaConsultaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MarcarNovaConsultaPortImpl implements MarcarNovaConsultaPort {

    private final MarcarConsultaRepository repository;

    @Override
    public MarcarConsulta execute(MarcarConsulta marcarConsulta) {

        if(repository.existsByCodigoMedicoAndDataHora(marcarConsulta.getCodigoMedico(), marcarConsulta.getDataHora())) {
            throw new ConsultaExistenteException("Profissional já possui uma consulta nesse horário");
        }

        return repository.save(marcarConsulta);
    }
}
