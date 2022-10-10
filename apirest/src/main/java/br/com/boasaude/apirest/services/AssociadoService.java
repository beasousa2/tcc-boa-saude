package br.com.boasaude.apirest.services;

import br.com.boasaude.apirest.dto.form.CriarAssociadoForm;
import br.com.boasaude.apirest.usecases.interfaces.CriarAssociadoUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class AssociadoService {

    private final CriarAssociadoUC usecase;

    public void criarAssociado(CriarAssociadoForm form) throws ExecutionException, InterruptedException {
        usecase.execute(form);
    }
}
