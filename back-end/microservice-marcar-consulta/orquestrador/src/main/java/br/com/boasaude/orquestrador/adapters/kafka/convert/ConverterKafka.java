package br.com.boasaude.orquestrador.adapters.kafka.convert;


import br.com.boasaude.orquestrador.dto.VerificaCoberturaPlanoDto;
import br.com.boasaude.microservicemarcarconsulta.verifica_cobertura_plano_request.VerificaCoberturaPlano;
import org.springframework.stereotype.Component;

@Component
public class ConverterKafka {

    public VerificaCoberturaPlanoDto avroToDto(VerificaCoberturaPlano avro) {
        return VerificaCoberturaPlanoDto.builder()
                .associadoId(avro.getData().getAssociadoId().toString())
                .procedimento(avro.getData().getProcedimento().toString())
                .planoId(avro.getData().getPlanoId())
                .codigoConveniado(avro.getData().getCodigoConveniado().toString())
                .matricula(avro.getData().getMatricula().toString())
                .codigoMedico(avro.getData().getCodigoMedico().toString())
                .dataHora(avro.getData().getDataHora().toString())
                .descricao(avro.getData().getDescricao().toString())
                .build();
    }

//    public CoberturaPlanoVerificado dtoToAvro(CoberturaPlanoVerificadoDTO dto) {
//        return CoberturaPlanoVerificado.newBuilder()
//                .setData(CoberturaPlanoVerificadoData.newBuilder()
//                        .setAssociadoId(dto.getAssociadoId())
//                        .setIsCoberto(dto.getIsCoberto())
//                        .setPlanoId(dto.getPlanoId())
//                        .setAssociadoId(dto.getAssociadoId())
//                        .setCodigoConveniado(dto.getCodigoConveniado())
//                        .setCodigoMedico(dto.getCodigoConveniado())
//                        .setDataHora(dto.getDataHora())
//                        .setDescricao(dto.getDescricao())
//                        .setMatricula(dto.getMatricula())
//                        .setProcedimento(dto.getProcedimento())
//                        .build())
//                .build();
//    }
}
