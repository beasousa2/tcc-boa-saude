package br.com.boasaude.microserviceconveniado.adapters.kafka.header;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class KafkaHeader {
     public static final String CORRELATIONID = "correlationId";
     public static final String TRANSACTIONID = "transactionId";

     public List<Header> getHeaders(final KafkaHeaderDto dto) {
          List<Header> headers = new ArrayList<>();
          headers.add(new RecordHeader("specversion", "1.0".getBytes()));
          headers.add(new RecordHeader("eventversion", "1.0".getBytes()));
          headers.add(new RecordHeader(CORRELATIONID, dto.getCorrelationId().getBytes()));
          headers.add(new RecordHeader("id", "1.0".getBytes()));
          headers.add(new RecordHeader("time", LocalDateTime.now().toString().getBytes()));
          headers.add(new RecordHeader(TRANSACTIONID, dto.getTransactionId().getBytes()));
          return headers;
     }


}