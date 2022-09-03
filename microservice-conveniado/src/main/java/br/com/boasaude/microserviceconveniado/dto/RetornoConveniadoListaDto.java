package br.com.boasaude.microserviceconveniado.dto;

import br.com.boasaude.microserviceconveniado.dto.conveniado.ConveniadoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RetornoConveniadoListaDto {

    private List<ConveniadoDto> conveniadoDtoList;
}
