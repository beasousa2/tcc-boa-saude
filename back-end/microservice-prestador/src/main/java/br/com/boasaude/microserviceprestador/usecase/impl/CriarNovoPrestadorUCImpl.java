package br.com.boasaude.microserviceprestador.usecase.impl;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Prestador;
import br.com.boasaude.microserviceprestador.api.converter.PrestadorConverter;
import br.com.boasaude.microserviceprestador.api.form.PrestadorForm;
import br.com.boasaude.microserviceprestador.ports.interfaces.CriarPrestadorPort;
import br.com.boasaude.microserviceprestador.usecase.interfaces.CriarNovoPrestadorUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CriarNovoPrestadorUCImpl implements CriarNovoPrestadorUC {

    private final CriarPrestadorPort port;
    private final PrestadorConverter converter;

    @Override
    public void execute(PrestadorForm form) {
        Prestador prestador = converter.formToEntity(form);
        port.execute(prestador);
    }
}
