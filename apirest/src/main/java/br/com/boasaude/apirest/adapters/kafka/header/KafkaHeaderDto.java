package br.com.boasaude.apirest.adapters.kafka.header;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class KafkaHeaderDto {

    private String transactionId;
    private String correlationId;
    private String topico;
    private String fluxo;
}
