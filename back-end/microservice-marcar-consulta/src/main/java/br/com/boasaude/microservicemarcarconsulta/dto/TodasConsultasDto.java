package br.com.boasaude.microservicemarcarconsulta.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class TodasConsultasDto {

    private List<ConsultaDto> consultas;
}
