package br.com.boasaude.associado.microservicecore.adapters.database.converter;

import br.com.boasaude.associado.microservicecore.adapters.database.entities.Associado;
import br.com.boasaude.associado.microservicecore.adapters.database.entities.Endereco;
import br.com.boasaude.associado.microservicecore.adapters.database.entities.Plano;
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
                .plano(
                        Plano.builder()
                                .descricao(dto.getPlanoDto().getDescricao())
                                .apartamento(dto.getPlanoDto().getApartamento())
                                .odontologico(dto.getPlanoDto().getOdontologico())
                                .enfermaria(dto.getPlanoDto().getEnfermaria())
                                .precoMensalidade(dto.getPlanoDto().getPrecoMensalidade())
                                .build()
                )

                .endereco(
                        Endereco.builder()
                                .logradouro(dto.getEnderecoDto().getLogradouro())
                                .uf(dto.getEnderecoDto().getUf())
                                .cep(dto.getEnderecoDto().getCep())
                                .bairro(dto.getEnderecoDto().getBairro())
                                .cidade(dto.getEnderecoDto().getCidade())
                                .complemento(dto.getEnderecoDto().getComplemento())
                                .numero(dto.getEnderecoDto().getNumero())
                                .build()
                )
                .build();
    };
}
