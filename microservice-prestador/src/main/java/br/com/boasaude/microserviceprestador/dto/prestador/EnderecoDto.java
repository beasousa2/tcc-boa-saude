package br.com.boasaude.microserviceprestador.dto.prestador;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EnderecoDto {

    private String logradouro;
    private String cep;
    private String complemento;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
}
