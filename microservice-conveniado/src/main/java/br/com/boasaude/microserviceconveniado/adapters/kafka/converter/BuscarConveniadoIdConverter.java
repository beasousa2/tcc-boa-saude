package br.com.boasaude.microserviceconveniado.adapters.kafka.converter;

import br.com.boasaude.microserviceconveniado.buscar_conveniado_id.BuscarConveniadoId;
import br.com.boasaude.microserviceconveniado.dto.BuscarConveniadoIdDto;
import org.springframework.stereotype.Component;

@Component
public class BuscarConveniadoIdConverter {

    public BuscarConveniadoIdDto avroToDto(BuscarConveniadoId avro) {
        return BuscarConveniadoIdDto.builder()
                .idConveniado(avro.getData().getIdConveniado())
                .build();
    }
}
