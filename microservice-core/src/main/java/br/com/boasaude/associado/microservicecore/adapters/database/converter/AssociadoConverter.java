package br.com.boasaude.associado.microservicecore.adapters.database.converter;

import br.com.boasaude.associado.microservicecore.adapters.database.entities.Associado;
import br.com.boasaude.associado.microservicecore.adapters.database.entities.Endereco;
import br.com.boasaude.associado.microservicecore.adapters.database.entities.Plano;
import br.com.boasaude.associado.microservicecore.dto.CriaAssociadoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AssociadoConverter {

    public Associado dtoToEntity(CriaAssociadoDto dto){
        return Associado.builder()
                .nome(dto.getInfoPessoaisDto().getNome())
                .dataNascimento(dto.getInfoPessoaisDto().getDataNascimento())
                .cpf(dto.getInfoPessoaisDto().getCpf())
                .rg(dto.getInfoPessoaisDto().getRg())
                .orgaoEmissor(dto.getInfoPessoaisDto().getOrgaoEmissor())
                .dataEmissao(dto.getInfoPessoaisDto().getDataEmissao())
                .estadoCivil(dto.getInfoPessoaisDto().getEstadoCivil().name())
                .genero(dto.getInfoPessoaisDto().getGenero().name())
                .telefone(dto.getInfoPessoaisDto().getTelefone())
                .email(dto.getInfoPessoaisDto().getEmail())
                .matricula(dto.getInfoPessoaisDto().getMatricula())
                .situacao(dto.getInfoPessoaisDto().getSituacao().name())
                .descricao(dto.getPlanoDto().getDescricao())
                .apartamento(dto.getPlanoDto().getApartamento())
                .odontologico(dto.getPlanoDto().getOdontologico())
                .enfermaria(dto.getPlanoDto().getEnfermaria())
                .precoMensalidade(dto.getPlanoDto().getPrecoMensalidade())
                .logradouro(dto.getEnderecoDto().getLogradouro())
                .uf(dto.getEnderecoDto().getUf())
                .cep(dto.getEnderecoDto().getCep())
                .bairro(dto.getEnderecoDto().getBairro())
                .cidade(dto.getEnderecoDto().getCidade())
                .complemento(dto.getEnderecoDto().getComplemento())
                .numero(dto.getEnderecoDto().getNumero())

                .build();
    };
}
