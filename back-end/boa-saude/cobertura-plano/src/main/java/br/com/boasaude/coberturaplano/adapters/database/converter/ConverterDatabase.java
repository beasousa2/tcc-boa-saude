package br.com.boasaude.coberturaplano.adapters.database.converter;

import br.com.boasaude.coberturaplano.adapters.database.entities.CoberturaPlano;
import br.com.boasaude.coberturaplano.dto.CoberturaPlanoVerificadoDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ConverterDatabase {

    public CoberturaPlanoVerificadoDTO entityToDto(CoberturaPlano cobertura, Boolean isCoberto){
        return CoberturaPlanoVerificadoDTO.builder()
                .associadoId(cobertura.getAssociadoId())
                .isCoberto(isCoberto)
                .planoId(cobertura.getPlanoId())
                .build();
    }
}
