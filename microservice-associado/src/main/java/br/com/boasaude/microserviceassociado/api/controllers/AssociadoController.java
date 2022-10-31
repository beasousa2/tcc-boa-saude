package br.com.boasaude.microserviceassociado.api.controllers;

import br.com.boasaude.microserviceassociado.api.form.AssociadoForm;
import br.com.boasaude.microserviceassociado.api.form.ConsultaForm;
import br.com.boasaude.microserviceassociado.api.services.AssociadoService;
import br.com.boasaude.microserviceassociado.dto.AssociadoDTO;
import br.com.boasaude.microserviceassociado.dto.ConsultaDto;
import br.com.boasaude.microserviceassociado.dto.DadosAssociadoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("v1/api/associado")
@RequiredArgsConstructor
public class AssociadoController {
    private final AssociadoService service;

    @PostMapping("new")
    public ResponseEntity<DadosAssociadoDto> save(@RequestBody @Valid AssociadoForm form, UriComponentsBuilder builder) {
        String id = service.save(form);
        URI uri = builder.path("v1/api/associado/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosAssociadoDto> getById(@PathVariable String id) {
        DadosAssociadoDto associadoDto = service.getAssociadoById(id);
        return ResponseEntity.ok(associadoDto);
    }

    @GetMapping("/complete/{id}")
    public ResponseEntity<AssociadoDTO> getByIdComplete(@PathVariable String id) {
        AssociadoDTO dto = service.getAssociadoByIdComplete(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("consulta")
    public ResponseEntity<ConsultaDto> getConsulta(@RequestBody ConsultaForm form) {
        ConsultaDto consulta = service.getConsulta(form);
        return ResponseEntity.ok(consulta);
    }
}
