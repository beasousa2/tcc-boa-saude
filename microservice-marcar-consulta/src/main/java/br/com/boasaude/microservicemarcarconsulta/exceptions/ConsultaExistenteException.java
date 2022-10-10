package br.com.boasaude.microservicemarcarconsulta.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConsultaExistenteException extends RuntimeException {

    private String message;
}
