package br.com.boasaude.microserviceconveniado.dto.conveniado;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ConveniadoDto {

    private Long id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private List<ProcedimentoDto> procedimentos;
    private List<EspecialidadeDto> especialidades;
    private String tipoConveniado;
    private EnderecoDto endereco;
}
