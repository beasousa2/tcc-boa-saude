package br.com.boasaude.microserviceprestador.dto;

import br.com.boasaude.microserviceprestador.dto.prestador.PrestadorByIdDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BuscarPrestadoresEspecialidadeRespostaDto {

    private List<PrestadorByIdDto> prestadores;
}
