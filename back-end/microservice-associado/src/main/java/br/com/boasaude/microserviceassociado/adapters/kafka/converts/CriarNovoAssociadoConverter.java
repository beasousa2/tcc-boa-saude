package br.com.boasaude.microserviceassociado.adapters.kafka.converts;

import br.com.boasaude.associado.criar_associado.CriarAssociado;
import br.com.boasaude.microserviceassociado.dto.*;
import br.com.boasaude.microserviceassociado.enums.EstadoCivil;
import br.com.boasaude.microserviceassociado.enums.Genero;
import br.com.boasaude.microserviceassociado.enums.Situacao;
import br.com.boasaude.microserviceassociado.utils.GerarMatricula;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class CriarNovoAssociadoConverter {


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

}
