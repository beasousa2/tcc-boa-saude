package br.com.boasaude.microserviceprestador.usecase.interfaces;

import br.com.boasaude.microserviceprestador.api.form.PrestadorForm;

public interface CriarNovoPrestadorUC {

    void execute(PrestadorForm form);
}
