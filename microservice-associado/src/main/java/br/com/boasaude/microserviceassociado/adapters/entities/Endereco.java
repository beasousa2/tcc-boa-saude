package br.com.boasaude.microserviceassociado.adapters.entities;

import lombok.*;

@Builder
@Getter
@Setter
public class Endereco {

    private String logradouro;
    private String cep;
    private String complemento;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
}
