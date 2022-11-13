package br.com.boasaude.microserviceassociado.adapters.kafka.header;

import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class KafkaHeader {

    public static final String TRANSACTIONID = "transactionId";
    public static final String CORRELATIONID = "correlationId";

    public List<Header> getHeaders(final KafkaHeaderDto dto) {
        List<Header> headers = new ArrayList<>();
        headers.add(new RecordHeader("specversion", "1.0".getBytes()));
        headers.add(new RecordHeader("eventversion", "1.0".getBytes()));
        headers.add(new RecordHeader("correlationId", dto.getCorrelationId().getBytes()));
        headers.add(new RecordHeader("id", "1.0".getBytes()));
        headers.add(new RecordHeader("time", LocalDateTime.now().toString().getBytes()));
        headers.add(new RecordHeader("transactionId", dto.getTransactionId().getBytes()));
        return headers;
    }

    public static KafkaHeaderDto retrieveHeader(
            String transactionId,
            String topico,
            String correlationId,
            String fluxo
    ) {
        return KafkaHeaderDto.builder()
                .transactionId(transactionId)
                .correlationId(correlationId)
                .topico(topico)
                .fluxo(fluxo)
                .build();
    }
}
