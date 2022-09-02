package br.com.boasaude.microserviceconveniado.dto.conveniado;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;

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
