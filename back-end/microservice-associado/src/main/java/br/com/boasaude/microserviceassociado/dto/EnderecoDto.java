package br.com.boasaude.microserviceassociado.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
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
