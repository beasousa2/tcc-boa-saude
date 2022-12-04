package br.com.boasaude.microserviceprestador.ports.interfaces;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Prestador;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface PrestadorPort {

    Optional<Prestador> execute(String id);
    List<Prestador> execute (String nomeEspecialidade, String cidade);
    void execute(Prestador prestador);
}
