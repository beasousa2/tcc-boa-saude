package br.com.boasaude.apirest.adapters.kafka.converter;

import br.com.boasaude.apirest.dto.AssociadoDto;
import br.com.boasaude.apirest.dto.form.CriarAssociadoForm;
import br.com.boasaude.apirest.enums.Situacao;
import br.com.boasaude.associado.criar_associado.*;
import br.com.boasaude.associado.criar_associado_resposta.CriarAssociadoResposta;
import br.com.boasaude.associado.criar_associado_resposta.CriarAssociadoRespostaData;
import org.springframework.stereotype.Service;

@Service
public class CriarAssociadoConverter {

    public CriarAssociado dtoToAvro(CriarAssociadoForm form) {
        CriarAssociadoData avro = CriarAssociadoData.newBuilder()
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

        return CriarAssociado.newBuilder()
                .setData(avro)
                .build();
    }

    public AssociadoDto avroToDto(CriarAssociadoResposta payload) {

        return AssociadoDto.builder()
                .nome(payload.getData().getNomeCompleto().toString())
                .id(payload.getData().getIdAssociado())
                .matricula(payload.getData().getMatricula().toString())
                .email(payload.getData().getEmail().toString())
                .situacao(Situacao.valueOf(payload.getData().getSituacao().toString()))
                .build();
    }

}
