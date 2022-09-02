package br.com.boasaude.microserviceconveniado.usecase.impl;

import br.com.boasaude.microserviceconveniado.dto.BuscarConveniadoNomeEspecialidadeDto;
import br.com.boasaude.microserviceconveniado.ports.interfaces.BuscarConveniadoNomeEspecialidadePort;
import br.com.boasaude.microserviceconveniado.usecase.interfaces.BuscarConveniadoNomeEspecialidadeUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuscarConveniadoNomeEspecialidadeUCImpl implements BuscarConveniadoNomeEspecialidadeUC {

    private BuscarConveniadoNomeEspecialidadePort port;


    public void execute(BuscarConveniadoNomeEspecialidadeDto dto) {
        port.execute(dto.getNomeEspecialidade());
    }
}
