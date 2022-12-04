package br.com.boasaude.microserviceprestador.adapters.database.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


import java.util.List;

@Document(collection = "prestador_agenda")
@Builder
@Data
public class Agenda {

    @Id
    private String id;
    @DocumentReference(lazy = true)
    private Prestador prestador;
    private List<DataDisponivel> datas;
}
