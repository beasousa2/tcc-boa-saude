package br.com.boasaude.microserviceconveniado.adapters.kafka.converter;

import br.com.boasaude.microserviceconveniado.buscar_conveniado_nome_especialidade.BuscarConveniadoNomeEspecialidade;

import br.com.boasaude.microserviceconveniado.buscar_conveniado_nome_especialidade_resposta.*;
import br.com.boasaude.microserviceconveniado.dto.BuscarConveniadoNomeEspecialidadeDto;
import br.com.boasaude.microserviceconveniado.dto.RetornoConveniadoListaDto;
import br.com.boasaude.microserviceconveniado.dto.conveniado.ConveniadoDto;
import br.com.boasaude.microserviceconveniado.adapters.database.entities.Conveniado;
import br.com.boasaude.microserviceconveniado.dto.conveniado.EnderecoDto;
import br.com.boasaude.microserviceconveniado.dto.conveniado.EspecialidadeDto;
import br.com.boasaude.microserviceconveniado.dto.conveniado.ProcedimentoDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuscarConveniadoNomeEspecialidadeConverter {

    public RetornoConveniadoListaDto entityToDto(List<Conveniado> conveniados) {
        return RetornoConveniadoListaDto.builder()
                .conveniadoDtoList(conveniados.stream()
                        .map(conveniado -> ConveniadoDto.builder()
                                .id(conveniado.getId())
                                .nomeFantasia(conveniado.getNomeFantasia())
                                .cnpj(conveniado.getCnpj())
                                .endereco(EnderecoDto.builder()
                                        .logradouro(conveniado.getEndereco().getLogradouro())
                                        .cep(conveniado.getEndereco().getCep())
                                        .numero(conveniado.getEndereco().getNumero())
                                        .complemento(conveniado.getEndereco().getComplemento())
                                        .bairro(conveniado.getEndereco().getBairro())
                                        .cidade(conveniado.getEndereco().getCidade())
                                        .uf(conveniado.getEndereco().getUf())
                                        .build())
                                .especialidades(conveniado.getEspecialidades().stream()
                                        .map(esp -> EspecialidadeDto.builder()
                                                .especialidade(esp.getEspecialidade())
                                                .build())
                                        .collect(Collectors.toList()))
                                .procedimentos(conveniado.getProcedimentos().stream()
                                        .map(pro -> ProcedimentoDto.builder()
                                                .id(pro.getId())
                                                .nomeProcedimento(pro.getNomeProcedimento())
                                                .build())
                                        .collect(Collectors.toList()))
                                .tipoConveniado(conveniado.getTipoConveniado().name())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    public BuscarConveniadoNomeEspecialidadeDto avroToDto(BuscarConveniadoNomeEspecialidade avro) {
        return BuscarConveniadoNomeEspecialidadeDto.builder()
                .nomeEspecialidade(avro.getData().getNomeEspecialidade().toString())
                .build();
    }

    public BuscarConveniadoNomeEspecialidadeResposta dtoToAvro(RetornoConveniadoListaDto dto) {
        return BuscarConveniadoNomeEspecialidadeResposta.newBuilder()
                .setData(BuscarConveniadoNomeEspecialidadeRespostaData.newBuilder()
                        .setConveniados(dto.getConveniadoDtoList().stream()
                                .map(con -> ConveniadoResposta.newBuilder()
                                        .setId(con.getId())
                                        .setNomeFantasia(con.getNomeFantasia())
                                        .setEndereco(Endereco.newBuilder()
                                                .setLogradouro(con.getEndereco().getLogradouro())
                                                .setCep(con.getEndereco().getCep())
                                                .setNumero(con.getEndereco().getNumero())
                                                .setBairro(con.getEndereco().getBairro())
                                                .setCidade(con.getEndereco().getCidade())
                                                .setComplemento(con.getEndereco().getComplemento())
                                                .setUf(con.getEndereco().getUf())
                                                .build())
                                        .setEspecialidades(con.getEspecialidades().stream()
                                                .map(esp -> Especialidade.newBuilder()
                                                        .setEspecialidade(esp.getEspecialidade())
                                                        .build()
                                                )
                                                .collect(Collectors.toList()))
                                        .setProcedimentos(con.getProcedimentos().stream()
                                                .map(pro -> Procedimento.newBuilder()
                                                        .setId(pro.getId())
                                                        .setProcedimento(pro.getNomeProcedimento())
                                                        .build())
                                                .collect(Collectors.toList()))
                                        .setTipoConveniado(con.getTipoConveniado())
                                        .build())
                                .collect(Collectors.toList()))
                        .build())
                .build();
    }
}
