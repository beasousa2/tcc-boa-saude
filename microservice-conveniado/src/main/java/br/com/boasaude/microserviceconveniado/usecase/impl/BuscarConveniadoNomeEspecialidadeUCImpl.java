package br.com.boasaude.microserviceconveniado.usecase.impl;

import br.com.boasaude.microserviceconveniado.adapters.database.entities.Conveniado;
import br.com.boasaude.microserviceconveniado.adapters.kafka.converter.BuscarConveniadoNomeEspecialidadeConverter;
import br.com.boasaude.microserviceconveniado.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceconveniado.adapters.kafka.producer.BuscarConveniadoNomeEspencialidadeProducer;
import br.com.boasaude.microserviceconveniado.buscar_conveniado_nome_especialidade_resposta.BuscarConveniadoNomeEspecialidadeResposta;
import br.com.boasaude.microserviceconveniado.dto.BuscarConveniadoNomeEspecialidadeDto;
import br.com.boasaude.microserviceconveniado.dto.BuscarConveniadoNomeEspecialidadeRespostaDto;
import br.com.boasaude.microserviceconveniado.ports.interfaces.BuscarConveniadoNomeEspecialidadePort;
import br.com.boasaude.microserviceconveniado.usecase.interfaces.BuscarConveniadoNomeEspecialidadeUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarConveniadoNomeEspecialidadeUCImpl implements BuscarConveniadoNomeEspecialidadeUC {

    private final BuscarConveniadoNomeEspecialidadePort port;
    private final BuscarConveniadoNomeEspencialidadeProducer producer;
    private final BuscarConveniadoNomeEspecialidadeConverter converter;
    public void execute(BuscarConveniadoNomeEspecialidadeDto dto, KafkaHeaderDto kafkaHeaderDto) {
        List<Conveniado> conveniados =  port.execute(dto.getNomeEspecialidade());
        BuscarConveniadoNomeEspecialidadeRespostaDto listaDto = converter.entityToDto(conveniados);
        BuscarConveniadoNomeEspecialidadeResposta avro = converter.dtoToAvro(listaDto);

        producer.producerSuccess(avro, kafkaHeaderDto);

    }
}
