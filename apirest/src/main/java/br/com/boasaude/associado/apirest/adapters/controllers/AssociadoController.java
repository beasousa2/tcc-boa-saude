package br.com.boasaude.associado.apirest.adapters.controllers;

import br.com.boasaude.associado.apirest.dto.AssociadoDto;
import br.com.boasaude.associado.apirest.dto.form.CriarAssociadoForm;
import br.com.boasaude.associado.apirest.adapters.kafka.config.port.interfaces.CriarAssociadoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/associado")
public class AssociadoController {

    @Autowired
    private CriarAssociadoPort associadoPort;

    @PostMapping
    public ResponseEntity<AssociadoDto> criarAssociado(@RequestBody @Valid CriarAssociadoForm form) {
        AssociadoDto dto = form.formToDto();
        associadoPort.execute(form);
        return ResponseEntity.ok().build();
    }
}
