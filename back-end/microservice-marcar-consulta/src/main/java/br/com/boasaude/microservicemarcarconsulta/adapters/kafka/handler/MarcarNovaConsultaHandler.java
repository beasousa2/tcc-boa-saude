package br.com.boasaude.microservicemarcarconsulta.adapters.kafka.handler;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarcarNovaConsultaHandler extends AbstractKafkaHandler{
    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException e, Consumer<?, ?> consumer) {
        final String exceptionMessage = getExceptionMessage(e.getCause());
        System.out.println(exceptionMessage);
        consumer.commitAsync();
        return null;
    }
}
