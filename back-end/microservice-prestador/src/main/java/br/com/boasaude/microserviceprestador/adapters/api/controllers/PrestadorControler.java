package br.com.boasaude.microserviceprestador.adapters.api.controllers;

import br.com.boasaude.microserviceprestador.adapters.api.form.AgendaForm;
import br.com.boasaude.microserviceprestador.adapters.api.form.PrestadorForm;
import br.com.boasaude.microserviceprestador.dto.BuscarPrestadoresEspecialidadeRespostaDto;
import br.com.boasaude.microserviceprestador.dto.prestador.PrestadorByIdDto;
import br.com.boasaude.microserviceprestador.usecase.interfaces.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/api/prestador")
@RequiredArgsConstructor
public class PrestadorControler {

    private final PrestadorUC usecase;
    private final AgendaUC agendaUC;

    @GetMapping("/id")
    public ResponseEntity<PrestadorByIdDto> buscarPrestadorId(@RequestParam String id) {
        PrestadorByIdDto prestador = usecase.execute(id);
        return ResponseEntity.ok(prestador);
    }

    @GetMapping("/especialidade")
    public ResponseEntity<BuscarPrestadoresEspecialidadeRespostaDto> buscarPrestadoresEspecialidade(@RequestParam String especialidade, @RequestParam String cidade) {
        BuscarPrestadoresEspecialidadeRespostaDto prestadores = usecase.execute(especialidade, cidade);
        return ResponseEntity.ok(prestadores);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> salvarPrestador(@RequestBody @Valid PrestadorForm form) {
        usecase.execute(form);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PostMapping("/agenda")
    public ResponseEntity<HttpStatus> addAgenda(@RequestBody @Valid AgendaForm form) {
        agendaUC.execute(form);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }


}
