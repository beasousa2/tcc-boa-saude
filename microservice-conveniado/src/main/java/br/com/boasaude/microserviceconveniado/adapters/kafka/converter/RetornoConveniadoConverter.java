package br.com.boasaude.microserviceconveniado.adapters.kafka.converter;


import br.com.boasaude.microserviceconveniado.dto.conveniado.ConveniadoDto;
import br.com.boasaude.microserviceconveniado.retorno_conveniado.*;

import java.util.stream.Collectors;

public class RetornoConveniadoConverter {

    public RetornoConveniado dtoToAvro(ConveniadoDto dto) {
        RetornoConveniadoData avro = RetornoConveniadoData.newBuilder()
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
        return RetornoConveniado.newBuilder().setData(avro).build();

    }
}
