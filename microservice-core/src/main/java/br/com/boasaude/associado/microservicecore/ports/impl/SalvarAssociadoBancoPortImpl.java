package br.com.boasaude.associado.microservicecore.ports.impl;

import br.com.boasaude.associado.microservicecore.adapters.database.entities.Associado;
import br.com.boasaude.associado.microservicecore.adapters.database.repository.AssociadoRepository;
import br.com.boasaude.associado.microservicecore.ports.interfaces.SalvarAssociadoBancoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalvarAssociadoBancoPortImpl implements SalvarAssociadoBancoPort {

    private final AssociadoRepository associadoRepository;
    @Override
    public void execute(Associado associado) {
        associadoRepository.save(associado);
    }
}
