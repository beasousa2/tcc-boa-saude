package br.com.boasaude.microserviceprestador.adapters.api.form;

import br.com.boasaude.microserviceprestador.adapters.database.entities.DataDisponivel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import java.util.List;

@Getter
@Setter
public class AgendaForm {

    @NotNull
    private String idprestador;
    @NotNull
    private List<DataDisponivel> datasDisponiveis;
}
