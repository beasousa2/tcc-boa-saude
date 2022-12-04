package br.com.boasaude.microserviceassociado.adapters.api.controllers;

import br.com.boasaude.microserviceassociado.adapters.api.form.AssociadoForm;
import br.com.boasaude.microserviceassociado.dto.AssociadoDTO;
import br.com.boasaude.microserviceassociado.dto.ConsultaDto;
import br.com.boasaude.microserviceassociado.dto.ConsultasDto;
import br.com.boasaude.microserviceassociado.dto.DadosAssociadoDto;
import br.com.boasaude.microserviceassociado.usecase.interfaces.AssociadoUC;
import br.com.boasaude.microserviceassociado.usecase.interfaces.ConsultaUC;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/api/associado")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AssociadoController {
    private final AssociadoUC associadoUC;
    private final ConsultaUC consultaUC;

    @PostMapping()
    public ResponseEntity<DadosAssociadoDto> save(@RequestBody @Valid AssociadoForm form, UriComponentsBuilder builder) {
        String id = associadoUC.execute(form);
        URI uri = builder.path("v1/api/associado/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<DadosAssociadoDto>> getAssociados() {
        List<DadosAssociadoDto> dadosAssociadoDtos = associadoUC.execute();
        return ResponseEntity.ok(dadosAssociadoDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosAssociadoDto> getById(@PathVariable("id") String id) {
        DadosAssociadoDto associadoDto = associadoUC.buscarAssociadoDados(id);
        return ResponseEntity.ok(associadoDto);
    }

    @GetMapping("/complete/{id}")
    public ResponseEntity<AssociadoDTO> getByIdComplete(@PathVariable("id") String id) {
        AssociadoDTO dto = associadoUC.buscarAssociadoCompleto(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/consulta/{idConsultaMarcada}")
    public ResponseEntity<ConsultaDto> getConsulta(@PathVariable("idConsultaMarcada") Long idConsultaMarcada) {
        ConsultaDto consulta = consultaUC.execute(idConsultaMarcada);
        return ResponseEntity.ok(consulta);
    }

    @GetMapping("/consulta/todas/{matricula}")
    public ResponseEntity<ConsultasDto> getConsultas(@PathVariable("matricula") String matricula) {
        ConsultasDto dto = consultaUC.execute(matricula);
        return ResponseEntity.ok(dto);
    }
}
