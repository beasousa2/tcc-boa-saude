package br.com.boasaude.microserviceconveniado.usecase.impl;

import br.com.boasaude.microserviceconveniado.dto.BuscarConveniadoIdDto;
import br.com.boasaude.microserviceconveniado.ports.interfaces.BuscarConveniadoIdPort;
import br.com.boasaude.microserviceconveniado.usecase.interfaces.BuscarConveniadoIdUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuscarConveniadoIdUCImpl implements BuscarConveniadoIdUC {

    private final BuscarConveniadoIdPort port;

    public void execute(BuscarConveniadoIdDto dto) {
        port.execute(dto.getIdConveniado());
    }
}
