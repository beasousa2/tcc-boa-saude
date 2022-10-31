package br.com.boasaude.microserviceprestador.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ConsultaDto {

    private Long idConsulta;
    private String codigoPrestador;
    private String descricao;
    private String matriculaPaciente;
    private LocalDateTime dataHora;
}
