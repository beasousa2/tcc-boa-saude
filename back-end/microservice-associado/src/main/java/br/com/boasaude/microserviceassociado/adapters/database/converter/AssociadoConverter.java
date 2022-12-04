package br.com.boasaude.microserviceassociado.adapters.database.converter;

import br.com.boasaude.associado.criar_associado.CriarAssociado;
import br.com.boasaude.associado.criar_associado_resposta.CriarAssociadoResposta;
import br.com.boasaude.associado.criar_associado_resposta.CriarAssociadoRespostaData;
import br.com.boasaude.microserviceassociado.adapters.database.entities.Associado;
import br.com.boasaude.microserviceassociado.adapters.api.form.AssociadoForm;
import br.com.boasaude.microserviceassociado.dto.*;
import br.com.boasaude.microserviceassociado.enums.EstadoCivil;
import br.com.boasaude.microserviceassociado.enums.Genero;
import br.com.boasaude.microserviceassociado.enums.Situacao;
import br.com.boasaude.microserviceassociado.utils.GerarMatricula;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class AssociadoConverter {

    public AssociadoDTO converterComplete(Associado associado) {
        return AssociadoDTO.builder().build();
    }

    public DadosAssociadoDto converterData(Associado associado) {
        return DadosAssociadoDto.builder()
                .id(associado.getId())
                .matricula(associado.getMatricula())
                .nome(associado.getNome())
                .email(associado.getEmail())
                .status(Situacao.valueOf(associado.getSituacao()))
                .build();
    }

    public CriaAssociadoDto avroToDto(CriarAssociado avro) {

        return CriaAssociadoDto.builder()
                .infoPessoaisDto(InformacoesPessoaisDto.builder()
                        .nome(avro.getData().getInformacoesPessoais().getNomeCompleto().toString())
                        .dataNascimento(LocalDate.parse(avro.getData().getInformacoesPessoais().getDataNascimento()))
                        .cpf(avro.getData().getInformacoesPessoais().getCpf().toString())
                        .rg(avro.getData().getInformacoesPessoais().getRg().toString())
                        .orgaoEmissor(avro.getData().getInformacoesPessoais().getOrgaoEmissor().toString())
                        .dataEmissao(LocalDate.parse(avro.getData().getInformacoesPessoais().getDataEmissao()))
                        .telefone(avro.getData().getInformacoesPessoais().getTelefone().toString())
                        .email(avro.getData().getInformacoesPessoais().getEmail().toString())
                        .matricula(GerarMatricula.gerarMatricula(avro.getData().getInformacoesPessoais().getCpf().toString()))
                        .situacao(Situacao.valueOf(avro.getData().getInformacoesPessoais().getSituacao().toString()))
                        .estadoCivil(EstadoCivil.valueOf(avro.getData().getInformacoesPessoais().getEstadoCivil().toString()))
                        .genero(Genero.valueOf(avro.getData().getInformacoesPessoais().getGenero().toString())).build())
                .planoDto(PlanoDto.builder()
                        .descricao(avro.getData().getPlano().getDescricao().toString())
                        .apartamento(avro.getData().getPlano().getApartamento())
                        .odontologico(avro.getData().getPlano().getOdontologico())
                        .enfermaria(avro.getData().getPlano().getEnfermaria())
                        .precoMensalidade(BigDecimal.valueOf(avro.getData().getPlano().getPrecoMensalidade()))
                        .build())
                .enderecoDto(EnderecoDto.builder()
                        .logradouro(avro.getData().getEndereco().getLogradouro().toString())
                        .uf(avro.getData().getEndereco().getUf().toString())
                        .cep(avro.getData().getEndereco().getCep().toString())
                        .complemento(avro.getData().getEndereco().toString())
                        .numero(avro.getData().getEndereco().getNumero().toString())
                        .cidade(avro.getData().getEndereco().getCidade().toString())
                        .bairro(avro.getData().getEndereco().getBairro().toString())
                        .build())
                .build();
    }

    public CriarAssociadoResposta entityToAvro(Associado associado) {
        return CriarAssociadoResposta.newBuilder()
                .setData(CriarAssociadoRespostaData.newBuilder()
                        .setIdAssociado(associado.getId())
                        .setNomeCompleto(associado.getNome())
                        .setEmail(associado.getEmail())
                        .setMatricula(associado.getMatricula())
                        .setSituacao(associado.getSituacao())
                        .build())
                .build();
    }

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


    public CriaAssociadoDto formToDto(AssociadoForm form) {
        return CriaAssociadoDto.builder()
                .infoPessoaisDto(InformacoesPessoaisDto.builder()
                        .nome(form.getNome())
                        .dataNascimento(form.getDataNascimento())
                        .cpf(form.getCpf())
                        .rg(form.getRg())
                        .orgaoEmissor(form.getOrgaoEmissor())
                        .dataEmissao(form.getDataEmissao())
                        .estadoCivil(EstadoCivil.valueOf(form.getEstadoCivil()))
                        .email(form.getEmail())
                        .situacao(Situacao.ATIVO)
                        .telefone(form.getTelefone())
                        .genero(Genero.valueOf(form.getGenero()))
                        .matricula(GerarMatricula.gerarMatricula(form.getCpf()))
                        .build())
                .planoDto(PlanoDto.builder()
                        .odontologico(form.getPlano().getOdontologico())
                        .apartamento(form.getPlano().getApartamento())
                        .descricao(form.getPlano().getDescricao())
                        .enfermaria(form.getPlano().getEnfermaria())
                        .precoMensalidade(form.getPlano().getPrecoMensalidade())
                        .build())
                .enderecoDto(EnderecoDto.builder()
                        .logradouro(form.getEndereco().getLogradouro())
                        .complemento(form.getEndereco().getComplemento())
                        .numero(form.getEndereco().getNumero())
                        .cep(form.getEndereco().getCep())
                        .bairro(form.getEndereco().getBairro())
                        .cidade(form.getEndereco().getCidade())
                        .uf(form.getEndereco().getUf())
                        .build())

                .build();
    }
}
