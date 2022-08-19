package br.com.boasaude.associado.apirest.adapters.kafka.converter;

import br.com.boasaude.associado.apirest.dto.AssociadoDto;
import br.com.boasaude.associado.associado_criado_realizada.AssociadoCriadoRealizada;
import org.springframework.stereotype.Service;

@Service
public class AssociadoConverter {

    public AssociadoDto avroToDto(AssociadoCriadoRealizada payload) {
        AssociadoDto.builder()
                .nome(payload.getData().getInformacoesPessoais().getNomeCompleto().toString())

                .build();

        return null;
    }
}
