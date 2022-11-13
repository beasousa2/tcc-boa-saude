package br.com.boasaude.microserviceprestador.adapters.converters;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Prestador;
import br.com.boasaude.microserviceprestador.buscar_prestadores_especialidade_resposta.*;
import br.com.boasaude.microserviceprestador.buscar_prstadores_especialidade.BuscarPrestadoresEspecialidade;
import br.com.boasaude.microserviceprestador.dto.BuscarPrestadoresEspecialidadeDto;
import br.com.boasaude.microserviceprestador.dto.BuscarPrestadoresEspecialidadeRespostaDto;
import br.com.boasaude.microserviceprestador.dto.prestador.PrestadorByIdDto;
import br.com.boasaude.microserviceprestador.dto.prestador.EnderecoDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuscarPrestadoresEspecialidadeConverter {

    public BuscarPrestadoresEspecialidadeRespostaDto entityToPrestadoresEspecialidadeDto(List<Prestador> prestadores) {
        return BuscarPrestadoresEspecialidadeRespostaDto.builder()
                .prestadores(prestadores.stream()
                        .map(prestador -> PrestadorByIdDto.builder()
                                .id(prestador.getId())
                                .nomeCompleto(prestador.getNomeCompleto())
                                .telefone(prestador.getTelefone())
                                .tipoDocumento(prestador.getTipoDocumento())
                                .documento(prestador.getDocumento())
                                .endereco(EnderecoDto.builder()
                                        .logradouro(prestador.getLogradouro())
                                        .numero(prestador.getNumero())
                                        .bairro(prestador.getBairro())
                                        .build())
                                .build())
                        .collect(Collectors.toList()))
                .build();

    }

    public BuscarPrestadoresEspecialidadeDto avroToPrestadoresEspecialidadeDto(BuscarPrestadoresEspecialidade avro) {
        return BuscarPrestadoresEspecialidadeDto.builder()
                .nomeEspecialidade(avro.getData().getEspecialidade().toString())
                .build();
    }

    public BuscarPrestadoresEspecialidadeResposta dtoToAvro(BuscarPrestadoresEspecialidadeRespostaDto dto) {
        return BuscarPrestadoresEspecialidadeResposta.newBuilder()
                .setData(BuscarPrestadoresEspecialidadeRespostaData.newBuilder()
                        .setPrestadores(dto.getPrestadores().stream()
                                .map(col -> PrestadoresResposta.newBuilder()
                                        .setId(col.getId())
                                        .setNomeCompleto(col.getNomeCompleto())
                                        .setDocumento(col.getDocumento())
                                        .setTipoDocumento(col.getTipoDocumento().toString())
                                        .setEndereco(Endereco.newBuilder()
                                                .setLogradouro(col.getEndereco().getLogradouro())
                                                .setBairro(col.getEndereco().getBairro())
                                                .setNumero(col.getEndereco().getNumero())
                                                .build())
                                        .build())
                                .collect(Collectors.toList()))
                        .build())
                .build();
    }
}
