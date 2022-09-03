package br.com.boasaude.microserviceconveniado.adapters.kafka.converter;

import br.com.boasaude.microserviceconveniado.adapters.database.entities.Conveniado;
import br.com.boasaude.microserviceconveniado.buscar_conveniado_id.BuscarConveniadoId;
import br.com.boasaude.microserviceconveniado.buscar_conveniado_id_resposta.*;
import br.com.boasaude.microserviceconveniado.dto.BuscarConveniadoIdDto;
import br.com.boasaude.microserviceconveniado.dto.conveniado.ConveniadoDto;
import br.com.boasaude.microserviceconveniado.dto.conveniado.EnderecoDto;
import br.com.boasaude.microserviceconveniado.dto.conveniado.EspecialidadeDto;
import br.com.boasaude.microserviceconveniado.dto.conveniado.ProcedimentoDto;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BuscarConveniadoIdConverter {

    public BuscarConveniadoIdDto avroToDto(BuscarConveniadoId avro) {
        return BuscarConveniadoIdDto.builder()
                .idConveniado(avro.getData().getIdConveniado())
                .build();
    }

    public BuscarConveniadoIdResposta dtoToAvro(ConveniadoDto dto) {
        BuscarConveniadoIdRespostaData avro = BuscarConveniadoIdRespostaData.newBuilder()
                .setId(dto.getId())
                .setNomeFantasia(dto.getNomeFantasia())
                .setEndereco(Endereco.newBuilder()
                        .setLogradouro(dto.getEndereco().getLogradouro())
                        .setNumero(dto.getEndereco().getNumero())
                        .setCep(dto.getEndereco().getCep())
                        .setBairro(dto.getEndereco().getBairro())
                        .setCidade(dto.getEndereco().getCidade())
                        .setComplemento(dto.getEndereco().getComplemento())
                        .setUf(dto.getEndereco().getUf())
                        .build())
                .setProcedimentos(dto.getProcedimentos().stream()
                        .map(procedimento -> Procedimento.newBuilder()
                                .setId(procedimento.getId())
                                .setProcedimento(procedimento.getNomeProcedimento())
                                .build())
                        .collect(Collectors.toList()))
                .setEspecialidades(dto.getEspecialidades().stream()
                        .map(especialidade -> Especialidade.newBuilder()
                                .setId(especialidade.getId())
                                .setEspecialidade(especialidade.getEspecialidade())
                                .build())
                        .collect(Collectors.toList())                )
                .build();
        return BuscarConveniadoIdResposta.newBuilder().setData(avro).build();

    }

    public ConveniadoDto enityToDto(Optional<Conveniado> conveniado) {
        return conveniado.map(value -> ConveniadoDto.builder()
                .id(value.getId())
                .tipoConveniado(value.getTipoConveniado().toString())
                .nomeFantasia(value.getNomeFantasia())
                .cnpj(value.getCnpj())
                .endereco(EnderecoDto.builder()
                        .logradouro(value.getEndereco().getLogradouro())
                        .cep(value.getEndereco().getCep())
                        .numero(value.getEndereco().getNumero())
                        .bairro(value.getEndereco().getBairro())
                        .complemento(value.getEndereco().getComplemento())
                        .cidade(value.getEndereco().getCidade())
                        .uf(value.getEndereco().getUf())
                        .build())
                .procedimentos(value.getProcedimentos().stream().map(
                        pro -> ProcedimentoDto.builder()
                                .id(pro.getId())
                                .nomeProcedimento(pro.getNomeProcedimento())
                                .build()
                ).collect(Collectors.toList()))
                .especialidades(value.getEspecialidades().stream().map(
                        esp -> EspecialidadeDto.builder()
                                .id(esp.getId())
                                .especialidade(esp.getEspecialidade())
                                .build()
                ).collect(Collectors.toList()))
                .build()).orElse(null);
    }
}
