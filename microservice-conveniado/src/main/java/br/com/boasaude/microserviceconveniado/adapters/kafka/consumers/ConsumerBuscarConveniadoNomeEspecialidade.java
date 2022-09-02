package br.com.boasaude.microserviceconveniado.adapters.kafka.consumers;

import br.com.boasaude.microserviceconveniado.buscar_conveniado_nome_especialidade.BuscarConveniadoNomeEspecialidade;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConsumerBuscarConveniadoNomeEspecialidade {

    public void consumer(@Payload BuscarConveniadoNomeEspecialidade payload) {

    }
}
