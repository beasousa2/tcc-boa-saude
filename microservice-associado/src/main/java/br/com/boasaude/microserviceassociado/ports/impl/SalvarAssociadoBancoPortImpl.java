package br.com.boasaude.microserviceassociado.ports.impl;

import br.com.boasaude.associado.criar_associado_resposta.CriarAssociadoResposta;
import br.com.boasaude.microserviceassociado.adapters.entities.Associado;
import br.com.boasaude.microserviceassociado.adapters.database.repository.AssociadoRepository;
import br.com.boasaude.microserviceassociado.adapters.kafka.converts.CriarNovoAssociadoConverter;
import br.com.boasaude.microserviceassociado.ports.interfaces.SalvarAssociadoBancoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalvarAssociadoBancoPortImpl implements SalvarAssociadoBancoPort {

    private final AssociadoRepository associadoRepository;
    private final CriarNovoAssociadoConverter converter;
    @Override
    public CriarAssociadoResposta execute(Associado associado) {
        Associado result = associadoRepository.save(associado);
        return converter.entityToAvro(result);
    }
}
