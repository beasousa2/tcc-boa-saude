package br.com.boasaude.microserviceprestador.api.controllers;

import br.com.boasaude.microserviceprestador.api.form.PrestadorForm;
import br.com.boasaude.microserviceprestador.dto.BuscarPrestadoresEspecialidadeRespostaDto;
import br.com.boasaude.microserviceprestador.dto.prestador.PrestadorByIdDto;
import br.com.boasaude.microserviceprestador.usecase.interfaces.BuscarPrestadorIdUC;
import br.com.boasaude.microserviceprestador.usecase.interfaces.BuscarPretadoresEspecialidadeUC;
import br.com.boasaude.microserviceprestador.usecase.interfaces.CriarNovoPrestadorUC;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/api/prestador")
@RequiredArgsConstructor
public class PrestadorControler {

    private final BuscarPrestadorIdUC usecaseId;
    private final BuscarPretadoresEspecialidadeUC usecaseEspecialidade;
    private final CriarNovoPrestadorUC usecasePrestador;

    @GetMapping("/{id}")
    public ResponseEntity<PrestadorByIdDto> buscarPrestadorId(@RequestParam String id) {
        PrestadorByIdDto prestador = usecaseId.executeController(id);
        return ResponseEntity.ok(prestador);
    }

    @GetMapping("/especialidade/{especialidade}")
    public ResponseEntity<BuscarPrestadoresEspecialidadeRespostaDto> buscarPrestadoresEspecialidade(@RequestParam String especialidade) {
        BuscarPrestadoresEspecialidadeRespostaDto prestadores = usecaseEspecialidade.executeController(especialidade);
        return ResponseEntity.ok(prestadores);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> salvarPrestador(@RequestBody @Valid PrestadorForm form) {
        usecasePrestador.execute(form);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
