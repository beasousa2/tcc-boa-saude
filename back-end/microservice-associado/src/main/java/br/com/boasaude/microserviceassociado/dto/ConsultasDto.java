package br.com.boasaude.microserviceassociado.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
@Builder
@Getter
public class ConsultasDto {

    private List<ConsultaDto> consultas;
}
