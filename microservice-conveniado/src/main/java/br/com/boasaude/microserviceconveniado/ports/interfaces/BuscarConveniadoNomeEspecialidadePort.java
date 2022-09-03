package br.com.boasaude.microserviceconveniado.ports.interfaces;

import br.com.boasaude.microserviceconveniado.adapters.database.entities.Conveniado;

import java.util.List;

public interface BuscarConveniadoNomeEspecialidadePort {

    List<Conveniado> execute(String nomeEspecialidade);
}
