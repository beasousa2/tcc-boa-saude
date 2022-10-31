package br.com.boasaude.microserviceassociado.adapters.entities;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "associado_consulta")
@Builder
@Getter
public class Consulta {

    @Id
    private String id;
    private String idConsultaMarcada;
    private LocalDateTime dataHora;
    private String matricula;
    private String codigoPaciente;
    private String codigoMedico;
    private String codigoConveniado;
    private String descricao;
}
