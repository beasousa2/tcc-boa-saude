package br.com.boasaude.microserviceprestador.usecase.impl;

import br.com.boasaude.microserviceprestador.adapters.converters.PrestadorConverter;
import br.com.boasaude.microserviceprestador.adapters.database.entities.Prestador;
import br.com.boasaude.microserviceprestador.adapters.api.form.PrestadorForm;
import br.com.boasaude.microserviceprestador.dto.BuscarPrestadoresEspecialidadeRespostaDto;
import br.com.boasaude.microserviceprestador.dto.prestador.PrestadorByIdDto;
import br.com.boasaude.microserviceprestador.ports.interfaces.PrestadorPort;
import br.com.boasaude.microserviceprestador.usecase.interfaces.PrestadorUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PrestadorUCImpl implements PrestadorUC {

    private final PrestadorPort port;
    private final PrestadorConverter converter;
    @Override
    public void execute(PrestadorForm form) {
        Prestador prestador = converter.formToEntity(form);
        port.execute(prestador);
    }

    @Override
    public PrestadorByIdDto execute(String id) {
        Optional<Prestador> prestador = port.execute(id);
        return prestador.map(converter::toPrestadorIdDto).orElse(null);
    }

    @Override
    public BuscarPrestadoresEspecialidadeRespostaDto execute(String especialidade, String cidade) {
        List<Prestador> prestadores = port.execute(especialidade, cidade);

        return converter.converter(prestadores);
    }
}
