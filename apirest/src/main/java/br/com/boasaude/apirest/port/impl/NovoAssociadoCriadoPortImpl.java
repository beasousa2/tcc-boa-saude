package br.com.boasaude.apirest.port.impl;


import br.com.boasaude.apirest.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.apirest.dto.AssociadoDto;
import br.com.boasaude.apirest.port.interfaces.NovoAssociadoCriadoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NovoAssociadoCriadoPortImpl implements NovoAssociadoCriadoPort {



    @Override
    public void execute(AssociadoDto dto, KafkaHeaderDto kafkaHeaderDto) {


    }
}
