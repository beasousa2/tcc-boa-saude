package br.com.boasaude.associado.microservicecore.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoDto {

    private String logradouro;
    private String cep;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
}
