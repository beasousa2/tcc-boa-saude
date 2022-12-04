package br.com.boasaude.microserviceprestador.adapters.converters;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Agenda;
import br.com.boasaude.microserviceprestador.adapters.database.entities.DataDisponivel;
import br.com.boasaude.microserviceprestador.adapters.database.entities.Hora;
import br.com.boasaude.microserviceprestador.adapters.database.entities.Prestador;
import br.com.boasaude.microserviceprestador.adapters.api.form.AgendaForm;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class AgendaConverter {

    public Agenda formToEntity(AgendaForm form) {
        return Agenda.builder()
                .datas(form.getDatasDisponiveis().stream().map(
                        data -> DataDisponivel.builder()
                        .data(data.getData())
                        .horarios(data.getHorarios().stream().map(
                                hora -> Hora.builder()
                                        .hora(hora.getHora())
                                        .minuto(hora.getMinuto())
                                .build()
                        ).collect(Collectors.toList()))
                        .build()).collect(Collectors.toList()))
                .prestador(Prestador.builder()
                        .id(form.getIdprestador())
                        .build())
                .build();
    }
}
