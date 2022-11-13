package br.com.boasaude.microserviceprestador.adapters.converters;

import br.com.boasaude.microserviceprestador.adapters.database.entities.Prestador;
import br.com.boasaude.microserviceprestador.buscar_prestador_id_resposta.BuscarPrestadorIdResposta;
import br.com.boasaude.microserviceprestador.buscar_prestador_id_resposta.BuscarPrestadorIdRespostaData;
import br.com.boasaude.microserviceprestador.buscar_prestador_id_resposta.Endereco;
import br.com.boasaude.microserviceprestador.dto.BuscarPrestadorIdDto;
import br.com.boasaude.microserviceprestador.dto.prestador.PrestadorByIdDto;
import br.com.boasaude.microserviceprestador.dto.prestador.EnderecoDto;
import br.com.boasaude.microserviceprestador.buscar_prestador_id.BuscarPrestadorId;
import org.springframework.stereotype.Component;
@Component
public class BuscarPrestadorIdConverter {

    public PrestadorByIdDto entityToPrestadorIdDto(Prestador prestador) {
        return PrestadorByIdDto.builder()
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
                .build();
    }

    public BuscarPrestadorIdDto avroToBuscaPrestadorIdDto(BuscarPrestadorId avro) {
        return BuscarPrestadorIdDto.builder()
                .id((String) avro.getData().getIdPrestador())
                .build();
    }

    public BuscarPrestadorIdResposta prestadorIdToAvro(PrestadorByIdDto dto) {
        return BuscarPrestadorIdResposta.newBuilder()
                .setData(BuscarPrestadorIdRespostaData.newBuilder()
                        .setId(dto.getId())
                        .setNomeCompleto(dto.getNomeCompleto())
                        .setDocumento(dto.getDocumento())
                        .setTipoDocumento(dto.getTipoDocumento().toString())
                        .setEndereco(Endereco.newBuilder()
                                .setLogradouro(dto.getEndereco().getLogradouro())
                                .setBairro(dto.getEndereco().getBairro())
                                .setNumero(dto.getEndereco().getNumero())
                                .build())
                        .build())
                .build();
    }

    public PrestadorByIdDto toPrestadorIdDto(Prestador prestador) {
        return PrestadorByIdDto.builder()
                .id(prestador.getId())
                .nomeCompleto(prestador.getNomeCompleto())
                .telefone(prestador.getTelefone())
                .documento(prestador.getDocumento())
                .tipoDocumento(prestador.getTipoDocumento())
                .endereco(EnderecoDto.builder()
                        .logradouro(prestador.getLogradouro())
                        .numero(prestador.getNumero())
                        .bairro(prestador.getBairro())
                        .build())
                .build();
    }



}
