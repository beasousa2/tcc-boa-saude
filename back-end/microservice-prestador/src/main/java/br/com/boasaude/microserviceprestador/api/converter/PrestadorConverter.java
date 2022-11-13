package br.com.boasaude.microserviceprestador.api.converter;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Prestador;
import br.com.boasaude.microserviceprestador.api.form.PrestadorForm;
import br.com.boasaude.microserviceprestador.enums.TipoDocumento;
import org.springframework.stereotype.Component;

@Component
public class PrestadorConverter {

    public Prestador formToEntity(PrestadorForm form) {
        return Prestador.builder()
                .nomeCompleto(form.getNomeCompleto())
                .cpf(form.getCpf())
                .cnpj(form.getCnpj())
                .documento(form.getDocumento())
                .tipoDocumento(TipoDocumento.valueOf(form.getTipoDocumento()))
                .cep(form.getCep())
                .bairro(form.getBairro())
                .logradouro(form.getLogradouro())
                .numero(form.getNumero())
                .cidade(form.getCidade())
                .uf(form.getUf())
                .complemento(form.getComplemento())
                .email(form.getEmail())
                .telefone(form.getTelefone())
                .build();
    }
}
