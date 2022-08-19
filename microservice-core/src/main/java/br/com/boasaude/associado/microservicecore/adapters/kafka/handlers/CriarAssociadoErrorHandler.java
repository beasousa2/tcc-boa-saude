package br.com.boasaude.associado.microservicecore.adapters.kafka.handlers;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CriarAssociadoErrorHandler extends AbstractKafkaHandler {

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException e, Consumer<?, ?> consumer) {
        final String exceptionMessage = getExceptionMessage(e.getCause());
        System.out.println(exceptionMessage);
        consumer.commitAsync();
        return null;
    }
}
