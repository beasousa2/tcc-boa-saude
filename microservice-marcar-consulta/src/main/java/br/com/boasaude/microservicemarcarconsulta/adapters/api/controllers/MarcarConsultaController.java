package br.com.boasaude.microservicemarcarconsulta.adapters.api.controllers;

import br.com.boasaude.microservicemarcarconsulta.adapters.api.form.NovaConsultaForm;
import br.com.boasaude.microservicemarcarconsulta.usecase.interfaces.MarcarNovaConsultaUC;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/api/marcar-consulta")
@RequiredArgsConstructor
public class MarcarConsultaController {

    private final MarcarNovaConsultaUC novaConsulta;

    public ResponseEntity<?> novaConsulta(@RequestBody @Valid NovaConsultaForm form) {
        novaConsulta.execute(form);
        return ResponseEntity.ok().build();
    }
}
