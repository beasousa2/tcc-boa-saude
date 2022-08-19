package br.com.boasaude.associado.apirest.adapters.kafka.converter;

import br.com.boasaude.associado.apirest.dto.AssociadoDto;
import br.com.boasaude.associado.criar_associado_novo_realizada.*;
import org.springframework.stereotype.Service;

@Service
public class CriarAssociadoConverter {

    public CriaAssociadoNovoRealizada dtoToAvro(AssociadoDto dto) {
        CriarAssociadoNovoRealizadaData avro = CriarAssociadoNovoRealizadaData.newBuilder()
                .setInformacoesPessoais(InformacoesPessoais.newBuilder()
                        .setNomeCompleto(dto.getNome())
                        .setDataNascimento(dto.getDataNascimento().toString())
                        .setCpf(dto.getCpf())
                        .setRg(dto.getRg())
                        .setOrgaoEmissor(dto.getOrgaoEmissor())
                        .setDataEmissao(dto.getDataEmissao().toString())
                        .setEmail(dto.getEmail())
                        .setTelefone(dto.getTelefone())
                        .setEstadoCivil(dto.getEstadoCivil().getDescricao())
                        .setGenero(dto.getGenero().getName())
                        .setSituacao(dto.getSituacao().getCodigo())
                        .build())
                .setEndereco(Endereco.newBuilder()
                        .setLogradouro(dto.getEndereco().getLogradouro())
                        .setCep(dto.getEndereco().getCep())
                        .setComplemento(dto.getEndereco().getComplemento())
                        .setNumero(dto.getEndereco().getNumero())
                        .setBairro(dto.getEndereco().getBairro())
                        .setCidade(dto.getEndereco().getCidade())
                        .setUf(dto.getEndereco().getUf().name())
                        .build())
                .setPlano(Plano.newBuilder()
                        .setDescricao(dto.getPlano().getDescricao())
                        .setApartamento(dto.getPlano().getApartamento())
                        .setEnfermaria(dto.getPlano().getEnfermaria())
                        .setOdontologico(dto.getPlano().getOdontologico())
                        .setPrecoMensalidade(dto.getPlano().getPrecoMensalidade().doubleValue())
                        .build())
                .build();

        return CriaAssociadoNovoRealizada.newBuilder()
                .setData(avro)
                .build();
    }

}
