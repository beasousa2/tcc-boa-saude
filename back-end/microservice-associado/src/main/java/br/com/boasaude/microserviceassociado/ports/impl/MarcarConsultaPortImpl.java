package br.com.boasaude.microserviceassociado.ports.impl;

import br.com.boasaude.microserviceassociado.adapters.database.repository.ConsultaRepository;
import br.com.boasaude.microserviceassociado.adapters.entities.Consulta;
import br.com.boasaude.microserviceassociado.ports.interfaces.MarcarConsultaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MarcarConsultaPortImpl implements MarcarConsultaPort {
    private final ConsultaRepository repository;

    @Override
    public void execute(Consulta consulta) {
        repository.save(consulta);
    }
}
