package br.com.boasaude.microservicemarcarconsulta.adapters.api.controllers;

import br.com.boasaude.microservicemarcarconsulta.adapters.api.form.NovaConsultaForm;
import br.com.boasaude.microservicemarcarconsulta.dto.ConsultaDto;
import br.com.boasaude.microservicemarcarconsulta.dto.MarcarNovaConsultaDto;
import br.com.boasaude.microservicemarcarconsulta.dto.TodasConsultasDto;
import br.com.boasaude.microservicemarcarconsulta.usecase.interfaces.ConsultaUC;
import br.com.boasaude.microservicemarcarconsulta.usecase.interfaces.MarcarNovaConsultaUC;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/api/marcar-consulta")
@RequiredArgsConstructor
public class MarcarConsultaController {

    private final MarcarNovaConsultaUC novaConsulta;
    private final ConsultaUC consultaUC;

    @PostMapping
    public ResponseEntity<MarcarNovaConsultaDto> novaConsulta(@RequestBody @Valid NovaConsultaForm form) {
        novaConsulta.execute(form);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<TodasConsultasDto> consultas() {
        TodasConsultasDto dto = consultaUC.execute();
        return ResponseEntity.ok(dto);
    }
}
