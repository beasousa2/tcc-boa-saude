package br.com.boasaude.microservicemarcarconsulta.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED;

@ResponseStatus(value = METHOD_NOT_ALLOWED)
public class CoberturaPlanoNegadaException extends RuntimeException {

    public CoberturaPlanoNegadaException(String message) {super(message);}
}
