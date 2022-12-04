package br.com.boasaude.microserviceprestador.ports.impl;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Consulta;
import br.com.boasaude.microserviceprestador.adapters.database.repository.ConsultaRepository;
import br.com.boasaude.microserviceprestador.ports.interfaces.ConsultaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsultaPortImpl implements ConsultaPort {

    private final ConsultaRepository repository;

    @Override
    public void execute(Consulta consulta) {
        System.out.println("Consulta (PORT): " + consulta.getDataHora());
        repository.save(consulta);
    }
}
