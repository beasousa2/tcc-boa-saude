package br.com.boasaude.microserviceconveniado.adapters.kafka.handler;

import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;

import java.util.Optional;

public class AbstractKafkaHandler implements KafkaListenerErrorHandler {
    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException e) {
        return null;
    }

    protected String getExceptionMessage(Throwable cause) {
        return Optional.ofNullable(cause)
                .map(Throwable::getMessage)
                .orElse("Erro inesperado");
    }
}
