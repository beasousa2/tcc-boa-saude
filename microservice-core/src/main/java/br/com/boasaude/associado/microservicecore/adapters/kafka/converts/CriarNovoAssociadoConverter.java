package br.com.boasaude.associado.microservicecore.adapters.kafka.converts;

import br.com.boasaude.associado.criar_associado_novo_realizada.CriaAssociadoNovoRealizada;
import br.com.boasaude.associado.microservicecore.dto.AssociadoDto;
import br.com.boasaude.associado.microservicecore.enums.EstadoCivil;
import br.com.boasaude.associado.microservicecore.enums.Genero;
import br.com.boasaude.associado.microservicecore.enums.Situacao;
import br.com.boasaude.associado.microservicecore.utils.GerarMatricula;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class CriarNovoAssociadoConverter {


    public AssociadoDto avroToDto(CriaAssociadoNovoRealizada avro) {
        return AssociadoDto.builder()
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
                .genero(Genero.valueOf(avro.getData().getInformacoesPessoais().getGenero().toString()))
                .logradouro(avro.getData().getEndereco().getLogradouro().toString())
                .cep(avro.getData().getEndereco().getCep().toString())
                .numero(avro.getData().getEndereco().getNumero().toString())
                .complemento(avro.getData().getEndereco().getComplemento().toString())
                .bairro(avro.getData().getEndereco().getBairro().toString())
                .cidade(avro.getData().getEndereco().getCidade().toString())
                .uf(avro.getData().getEndereco().getUf().toString())
                .descricao(avro.getData().getPlano().getDescricao().toString())
                .apartamento(avro.getData().getPlano().getApartamento())
                .enfermaria(avro.getData().getPlano().getEnfermaria())
                .odontologico(avro.getData().getPlano().getOdontologico())
                .precoMensalidade(BigDecimal.valueOf(avro.getData().getPlano().getPrecoMensalidade()))
                .build();
    }
}
