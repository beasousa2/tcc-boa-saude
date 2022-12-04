package br.com.boasaude.microserviceprestador.adapters.converters;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Especialidade;
import br.com.boasaude.microserviceprestador.adapters.database.entities.Formacao;
import br.com.boasaude.microserviceprestador.adapters.database.entities.Prestador;
import br.com.boasaude.microserviceprestador.adapters.api.form.PrestadorForm;
import br.com.boasaude.microserviceprestador.dto.BuscarPrestadoresEspecialidadeRespostaDto;
import br.com.boasaude.microserviceprestador.dto.prestador.PrestadorByIdDto;
import br.com.boasaude.microserviceprestador.enums.TipoDocumento;
import br.com.boasaude.microserviceprestador.enums.TipoEspecialidade;
import br.com.boasaude.microserviceprestador.enums.TipoFormacao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PrestadorConverter {

    public BuscarPrestadoresEspecialidadeRespostaDto converter(List<Prestador> prestadores) {
        return BuscarPrestadoresEspecialidadeRespostaDto.builder()
                .prestadores(prestadores.stream()
                        .map(prestador -> PrestadorByIdDto.builder()
                                .id(prestador.getId())
                                .nomeCompleto(prestador.getNomeCompleto())
                                .telefone(prestador.getTelefone())
                                .tipoDocumento(prestador.getTipoDocumento())
                                .documento(prestador.getDocumento())
                                .bairro(prestador.getBairro())
                                .numero(prestador.getNumero())
                                .logradouro(prestador.getLogradouro())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    public PrestadorByIdDto entityToPrestadorIdDto(Prestador prestador) {
        return PrestadorByIdDto.builder()
                .id(prestador.getId())
                .nomeCompleto(prestador.getNomeCompleto())
                .telefone(prestador.getTelefone())
                .tipoDocumento(prestador.getTipoDocumento())
                .documento(prestador.getDocumento())

                .build();
    }

    public PrestadorByIdDto toPrestadorIdDto(Prestador prestador) {
        return PrestadorByIdDto.builder()
                .id(prestador.getId())
                .nomeCompleto(prestador.getNomeCompleto())
                .telefone(prestador.getTelefone())
                .documento(prestador.getDocumento())
                .tipoDocumento(prestador.getTipoDocumento())
                .logradouro(prestador.getLogradouro())
                .numero(prestador.getNumero())
                .bairro(prestador.getBairro())
                .build();
    }

    public Prestador formToEntity(PrestadorForm form) {
        return Prestador.builder()
                .nomeCompleto(form.getNomeCompleto())
                .cpf(form.getCpf())
                .cnpj(form.getCnpj())
                .documento(form.getDocumento())
                .tipoDocumento(TipoDocumento.valueOf(form.getTipoDocumento()))
                .cep(form.getCep())
                .bairro(form.getBairro())
                .logradouro(form.getLogradouro())
                .numero(form.getNumero())
                .cidade(form.getCidade())
                .uf(form.getUf())
                .complemento(form.getComplemento())
                .email(form.getEmail())
                .telefone(form.getTelefone())
                .formacoes(form.getFormacaoForms().stream().map(formacao -> Formacao.builder()
                        .anoConclusao(formacao.getAnoConclusao())
                        .anoInicio(formacao.getAnoInicio())
                        .anoConclusao(formacao.getAnoConclusao())
                        .curso(formacao.getCurso())
                        .instituicao(formacao.getInstituicao())
                        .tipoFormacao(TipoFormacao.valueOf(formacao.getTipoFormacao()))
                        .build()).collect(Collectors.toList()))
                .especialidades(form.getEspecialidadeForms().stream().map(especialidade ->
                        Especialidade.builder()
                                .nomeEspecialidade(especialidade.getNomeEspecialidade())
                                .tipo(TipoEspecialidade.valueOf(especialidade.getTipo()))
                                .build()
                ).collect(Collectors.toList()))
                .build();
    }


}
