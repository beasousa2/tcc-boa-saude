package br.com.boasaude.microservicemarcarconsulta.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND)
public class ConsultaExistenteException extends RuntimeException {

    public ConsultaExistenteException(String message) {
        super(message);
    }
}
