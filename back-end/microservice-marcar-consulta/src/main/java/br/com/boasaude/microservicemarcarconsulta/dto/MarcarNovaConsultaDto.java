package br.com.boasaude.microservicemarcarconsulta.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MarcarNovaConsultaDto {

    private LocalDateTime dataHora;
    private String matriculaPaciente;
    private String codigoMedico;
    private String codigoConveniado;
    private String descricao;

}
