package br.com.boasaude.microservicemarcarconsulta.adapters.api.handler;

import br.com.boasaude.microservicemarcarconsulta.exceptions.ConsultaExistenteException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ConsultaErrorHandler {

    @ResponseBody
    @ExceptionHandler(ConsultaExistenteException.class)
    @ResponseStatus(HttpStatus.FOUND)
    public String consultaExistenteHandler(ConsultaExistenteException ex) {
        return ex.getMessage();
    }
}
