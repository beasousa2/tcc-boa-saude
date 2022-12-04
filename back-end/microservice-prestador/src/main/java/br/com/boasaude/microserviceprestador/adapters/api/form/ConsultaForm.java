package br.com.boasaude.microserviceprestador.adapters.api.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ConsultaForm {

    private String codigoPrestador;
    private String descricao;
    private String matriculaPaciente;
    private LocalDateTime dataHora;
}
