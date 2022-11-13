package br.com.boasaude.microserviceassociado.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ConsultaDto {

    private String id;
    private LocalDateTime dataHora;
    private String matriculaPaciente;
    private String codigoPaciente;
    private String codigoMedico;
    private String codigoConveniado;
    private String descricao;
}
