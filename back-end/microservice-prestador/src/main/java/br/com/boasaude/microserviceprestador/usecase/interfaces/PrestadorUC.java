package br.com.boasaude.microserviceprestador.usecase.interfaces;

import br.com.boasaude.microserviceprestador.adapters.api.form.PrestadorForm;
import br.com.boasaude.microserviceprestador.dto.BuscarPrestadoresEspecialidadeRespostaDto;
import br.com.boasaude.microserviceprestador.dto.prestador.PrestadorByIdDto;
import org.springframework.stereotype.Component;

@Component
public interface PrestadorUC {

    void execute(PrestadorForm form);
    BuscarPrestadoresEspecialidadeRespostaDto execute(String especialidade, String cidade);
    PrestadorByIdDto execute(String id);


}
