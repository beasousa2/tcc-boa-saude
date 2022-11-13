package br.com.boasaude.microserviceassociado.api;

import br.com.boasaude.microserviceassociado.adapters.entities.Associado;
import br.com.boasaude.microserviceassociado.api.form.AssociadoForm;
import br.com.boasaude.microserviceassociado.api.form.ConsultaForm;
import br.com.boasaude.microserviceassociado.dto.*;
import br.com.boasaude.microserviceassociado.enums.EstadoCivil;
import br.com.boasaude.microserviceassociado.enums.Genero;
import br.com.boasaude.microserviceassociado.enums.Situacao;
import br.com.boasaude.microserviceassociado.utils.GerarMatricula;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    public DadosAssociadoDto associadoToDto(Associado associado) {
        return DadosAssociadoDto.builder()
                    .id(associado.getId())
                    .email(associado.getEmail())
                    .matricula(associado.getMatricula())
                    .nome(associado.getNome())
                    .status(Situacao.valueOf(associado.getSituacao()))
                    .build();

    }

    public AssociadoDTO associadoAllToDto(Associado associado) {
        return AssociadoDTO.builder()
                .infoPessoaisDto(InformacoesPessoaisDto.builder()
                        .id(associado.getId())
                        .matricula(associado.getMatricula())
                        .nome(associado.getNome())
                        .dataNascimento(associado.getDataNascimento())
                        .cpf(associado.getCpf())
                        .rg(associado.getRg())
                        .dataEmissao(associado.getDataEmissao())
                        .orgaoEmissor(associado.getOrgaoEmissor())
                        .email(associado.getEmail())
                        .estadoCivil(EstadoCivil.valueOf(associado.getEstadoCivil()))
                        .genero(Genero.valueOf(associado.getGenero()))
                        .situacao(Situacao.valueOf(associado.getSituacao()))
                        .build())
                .enderecoDto(EnderecoDto.builder()
                        .logradouro(associado.getLogradouro())
                        .cep(associado.getCep())
                        .numero(associado.getNumero())
                        .bairro(associado.getBairro())
                        .cidade(associado.getCidade())
                        .complemento(associado.getComplemento())
                        .uf(associado.getUf())
                        .build())
                .planoDto(PlanoDto.builder()
                        .apartamento(associado.getApartamento())
                        .descricao(associado.getDescricao())
                        .enfermaria(associado.getEnfermaria())
                        .odontologico(associado.getOdontologico())
                        .build())
                .build();
    }

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
