package br.com.boasaude.associado.microservicecore.adapters.database.converter;

import br.com.boasaude.associado.microservicecore.adapters.database.entities.Associado;
import br.com.boasaude.associado.microservicecore.dto.AssociadoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AssociadoConverter {

    public Associado dtoToEntity(AssociadoDto dto){
        return Associado.builder()
                .nome(dto.getNome())
                .dataNascimento(dto.getDataNascimento())
                .cpf(dto.getCpf())
                .rg(dto.getRg())
                .orgaoEmissor(dto.getOrgaoEmissor())
                .dataEmissao(dto.getDataEmissao())
                .estadoCivil(dto.getEstadoCivil().name())
                .genero(dto.getGenero().name())
                .telefone(dto.getTelefone())
                .email(dto.getEmail())
                .matricula(dto.getMatricula())
                .situacao(dto.getSituacao().name())
                .logradouro(dto.getLogradouro())
                .cep(dto.getCep())
                .numero(dto.getNumero())
                .complemento(dto.getComplemento())
                .bairro(dto.getBairro())
                .cidade(dto.getCidade())
                .uf(dto.getUf())
                .descricao(dto.getDescricao())
                .apartamento(dto.getApartamento())
                .enfermaria(dto.getEnfermaria())
                .odontologico(dto.getOdontologico())
                .precoMensalidade(dto.getPrecoMensalidade())
                .build();
    };
}
