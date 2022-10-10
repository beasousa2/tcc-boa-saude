package br.com.boasaude.apirest.usecases.interfaces;

import br.com.boasaude.apirest.dto.AssociadoDto;
import br.com.boasaude.apirest.dto.form.CriarAssociadoForm;

import java.util.concurrent.ExecutionException;

public interface CriarAssociadoUC {

    AssociadoDto execute(CriarAssociadoForm form) throws ExecutionException, InterruptedException;
}
