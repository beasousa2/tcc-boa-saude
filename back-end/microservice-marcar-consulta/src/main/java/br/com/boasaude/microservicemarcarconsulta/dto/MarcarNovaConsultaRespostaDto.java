package br.com.boasaude.microservicemarcarconsulta.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class MarcarNovaConsultaRespostaDto {

    private Long id;
    private LocalDateTime dataHora;
    private String matriculaPaciente;
    private String codigoPaciente;
    private String codigoMedico;
    private String codigoConveniado;
    private String descricao;
}
