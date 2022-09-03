package br.com.boasaude.microserviceconveniado.adapters.kafka.producer;

import br.com.boasaude.microserviceconveniado.adapters.kafka.header.KafkaHeader;
import br.com.boasaude.microserviceconveniado.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.microserviceconveniado.buscar_conveniado_nome_especialidade_resposta.BuscarConveniadoNomeEspecialidadeResposta;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuscarConveniadoNomeEspencialidadeProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaHeader kafkaHeader;

    private String topico;

    public void producerSuccess(BuscarConveniadoNomeEspecialidadeResposta avro, KafkaHeaderDto kafkaHeaderDto) {

    }

}
