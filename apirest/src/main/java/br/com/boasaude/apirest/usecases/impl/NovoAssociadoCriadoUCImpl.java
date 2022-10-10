package br.com.boasaude.apirest.usecases.impl;

import br.com.boasaude.apirest.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.apirest.dto.AssociadoDto;
import br.com.boasaude.apirest.port.interfaces.NovoAssociadoCriadoPort;
import br.com.boasaude.apirest.usecases.interfaces.NovoAssociadoCriadoUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NovoAssociadoCriadoUCImpl implements NovoAssociadoCriadoUC {

    private final NovoAssociadoCriadoPort port;

    @Override
    public void execute(AssociadoDto dto, KafkaHeaderDto kafkaHeaderDto) {
        port.execute(dto, kafkaHeaderDto);
    }
}
