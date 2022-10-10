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
    private String nomePaciente;
    private String matriculaPaciente;
    private Long codigoPaciente;
    private String endereco;
    private String nomeMedico;
    private String documento;
    private Long codigoMedico;
    private Long codigoConveniado;
    private String especialidade;
}
