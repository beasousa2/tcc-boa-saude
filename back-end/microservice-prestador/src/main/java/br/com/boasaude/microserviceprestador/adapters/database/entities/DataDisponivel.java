package br.com.boasaude.microserviceprestador.adapters.database.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "prestador_agenda_data")
@Builder
@Data
public class DataDisponivel {

    private String data;
    private String diaSemana;
    private List<Hora> horarios;
}
