package br.com.boasaude.associado.microservicecore.usecase.impl;

import br.com.boasaude.associado.microservicecore.adapters.database.converter.AssociadoConverter;
import br.com.boasaude.associado.microservicecore.adapters.database.entities.Associado;
import br.com.boasaude.associado.microservicecore.dto.CriaAssociadoDto;
import br.com.boasaude.associado.microservicecore.ports.interfaces.SalvarAssociadoBancoPort;
import br.com.boasaude.associado.microservicecore.usecase.interfaces.CriarNovoAssociadoUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CriarNovoAssociadoUCImpl implements CriarNovoAssociadoUC {

    private final SalvarAssociadoBancoPort salvarAssociadoPort;
    private final AssociadoConverter associadoConverter;

    public void execute(CriaAssociadoDto dto) {
        Associado associado = associadoConverter.dtoToEntity(dto);
        salvarAssociadoPort.execute(associado);
    }
}
