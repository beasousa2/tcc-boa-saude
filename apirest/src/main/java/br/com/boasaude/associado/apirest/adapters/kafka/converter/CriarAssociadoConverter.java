package br.com.boasaude.associado.apirest.adapters.kafka.converter;

import br.com.boasaude.associado.apirest.dto.AssociadoDto;
import br.com.boasaude.associado.apirest.dto.form.CriarAssociadoForm;
import br.com.boasaude.associado.apirest.enums.Situacao;
import br.com.boasaude.associado.criar_associado_novo_realizada.*;
import org.springframework.stereotype.Service;

@Service
public class CriarAssociadoConverter {

    public CriaAssociadoNovoRealizada dtoToAvro(CriarAssociadoForm form) {
        CriarAssociadoNovoRealizadaData avro = CriarAssociadoNovoRealizadaData.newBuilder()
                .setInformacoesPessoais(InformacoesPessoais.newBuilder()
                        .setNomeCompleto(form.getNome())
                        .setDataNascimento(form.getDataNascimento().toString())
                        .setCpf(form.getCpf())
                        .setRg(form.getRg())
                        .setOrgaoEmissor(form.getOrgaoEmissor())
                        .setDataEmissao(form.getDataEmissao().toString())
                        .setEmail(form.getEmail())
                        .setTelefone(form.getTelefone())
                        .setEstadoCivil(form.getEstadoCivil())
                        .setGenero(form.getGenero())
                        .setSituacao(Situacao.ATIVO.getCodigo())
                        .build())
                .setEndereco(Endereco.newBuilder()
                        .setLogradouro(form.getEndereco().getLogradouro())
                        .setCep(form.getEndereco().getCep())
                        .setComplemento(form.getEndereco().getComplemento())
                        .setNumero(form.getEndereco().getNumero())
                        .setBairro(form.getEndereco().getBairro())
                        .setCidade(form.getEndereco().getCidade())
                        .setUf(form.getEndereco().getUf())
                        .build())
                .setPlano(Plano.newBuilder()
                        .setDescricao(form.getPlano().getDescricao())
                        .setApartamento(form.getPlano().getApartamento())
                        .setEnfermaria(form.getPlano().getEnfermaria())
                        .setOdontologico(form.getPlano().getOdontologico())
                        .setPrecoMensalidade(form.getPlano().getPrecoMensalidade().doubleValue())
                        .build())
                .build();

        return CriaAssociadoNovoRealizada.newBuilder()
                .setData(avro)
                .build();
    }

}
