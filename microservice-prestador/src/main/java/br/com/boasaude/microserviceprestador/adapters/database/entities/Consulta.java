package br.com.boasaude.microserviceprestador.adapters.database.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "prestador_consulta")
@Builder
@Data
public class Consulta {

    @Id
    private String id;
    private Long idConsulta;
    private String codigoPrestador;
    private String descricao;
    private String matriculaPaciente;
    private LocalDateTime dataHora;

}
