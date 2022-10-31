package br.com.boasaude.microservicemarcarconsulta.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ConsultaDto {

    private Long id;
    private LocalDateTime dataHora;
    private String codigoMedico;
}
