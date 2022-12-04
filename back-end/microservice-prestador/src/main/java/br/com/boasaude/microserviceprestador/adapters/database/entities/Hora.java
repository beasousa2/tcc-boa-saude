package br.com.boasaude.microserviceprestador.adapters.database.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hora {

    private String hora;
    private String minuto;
}
