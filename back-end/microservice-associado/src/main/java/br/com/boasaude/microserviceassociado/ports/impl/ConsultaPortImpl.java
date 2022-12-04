package br.com.boasaude.microserviceassociado.ports.impl;

import br.com.boasaude.microserviceassociado.adapters.database.converter.ConsultaConverter;
import br.com.boasaude.microserviceassociado.adapters.database.repository.ConsultaRepository;
import br.com.boasaude.microserviceassociado.adapters.database.entities.Consulta;
import br.com.boasaude.microserviceassociado.dto.ConsultaDto;
import br.com.boasaude.microserviceassociado.dto.ConsultasDto;
import br.com.boasaude.microserviceassociado.ports.interfaces.ConsultaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ConsultaPortImpl implements ConsultaPort {
    private final ConsultaRepository repository;
    private final ConsultaConverter converter;

    @Override
    public void execute(Consulta consulta) {
        repository.save(consulta);
    }

    @Override
    public ConsultasDto execute(String matricula) {
        List<Consulta> consultas = repository.findAllByMatricula(matricula);
        return converter.converter(consultas);
    }

    @Override
    public ConsultaDto execute(Long idConsulta) {
        Optional<Consulta> consultaMarcada = repository.findByIdConsultaMarcada(idConsulta);
        return consultaMarcada.map(converter::converter).orElse(null);
    }


}
