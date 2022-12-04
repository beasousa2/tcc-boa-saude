package br.com.boasaude.microserviceassociado.adapters.database.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "associado_consulta")
@Builder
@Data
public class Consulta {

    @Id
    private String id;
    private Long idConsultaMarcada;
    private LocalDateTime dataHora;
    private String matricula;
    private String codigoMedico;
    private String codigoConveniado;
    private String descricao;
}
