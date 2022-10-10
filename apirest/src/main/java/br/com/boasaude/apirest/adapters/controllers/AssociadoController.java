package br.com.boasaude.apirest.adapters.controllers;


import br.com.boasaude.apirest.dto.AssociadoDto;
import br.com.boasaude.apirest.dto.form.CriarAssociadoForm;
import br.com.boasaude.apirest.usecases.interfaces.CriarAssociadoUC;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/v1/associado")
@RequiredArgsConstructor
public class AssociadoController {
    private final CriarAssociadoUC usecase;

    @PostMapping
    public ResponseEntity<AssociadoDto> criarAssociado(@RequestBody @Valid CriarAssociadoForm form, UriComponentsBuilder builder) throws ExecutionException, InterruptedException {

        AssociadoDto associadoDto = usecase.execute(form);
        return ResponseEntity.ok(associadoDto);
    }

    @GetMapping("/criado")
    public ResponseEntity<AssociadoDto> associadoCriado( AssociadoDto dto) {
        return ResponseEntity.ok(dto);
    }




}
