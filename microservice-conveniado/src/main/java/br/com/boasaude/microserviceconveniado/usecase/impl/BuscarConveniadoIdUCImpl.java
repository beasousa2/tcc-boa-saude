package br.com.boasaude.microserviceconveniado.usecase.impl;

import br.com.boasaude.microserviceconveniado.adapters.database.entities.Conveniado;
import br.com.boasaude.microserviceconveniado.dto.BuscarConveniadoIdDto;
import br.com.boasaude.microserviceconveniado.ports.interfaces.BuscarConveniadoIdPort;
import br.com.boasaude.microserviceconveniado.usecase.interfaces.BuscarConveniadoIdUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BuscarConveniadoIdUCImpl implements BuscarConveniadoIdUC {

    private final BuscarConveniadoIdPort port;

    public Optional<Conveniado> execute(BuscarConveniadoIdDto dto) {

        Optional<Conveniado> conveniado = port.execute(dto.getIdConveniado());
        return conveniado;
    }
}
