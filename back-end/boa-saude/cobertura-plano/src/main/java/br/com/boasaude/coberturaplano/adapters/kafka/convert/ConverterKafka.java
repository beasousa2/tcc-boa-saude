package br.com.boasaude.coberturaplano.adapters.kafka.convert;

import br.com.boasaude.coberturaplano.cobertura_plano_verificado_reply.CoberturaPlanoVerificado;
import br.com.boasaude.coberturaplano.cobertura_plano_verificado_reply.CoberturaPlanoVerificadoData;
import br.com.boasaude.coberturaplano.dto.CoberturaPlanoVerificadoDTO;
import br.com.boasaude.coberturaplano.dto.VerificaCoberturaPlanoDto;
import br.com.boasaude.microservicemarcarconsulta.verifica_cobertura_plano_request.VerificaCoberturaPlano;
import org.springframework.stereotype.Component;

@Component
public class ConverterKafka {

    public VerificaCoberturaPlanoDto avroToDto(VerificaCoberturaPlano avro) {
        return VerificaCoberturaPlanoDto.builder()
                .associadoId(avro.getData().getAssociadoId().toString())
                .planoId(avro.getData().getPlanoId())
                .procedimento(avro.getData().getProcedimento().toString())
                .planoId(avro.getData().getPlanoId())
                .build();
    }

    public CoberturaPlanoVerificado dtoToAvro(CoberturaPlanoVerificadoDTO dto) {
        return CoberturaPlanoVerificado.newBuilder()
                .setData(CoberturaPlanoVerificadoData.newBuilder()
                        .setAssociadoId(dto.getAssociadoId())
                        .setIsCoberto(dto.getIsCoberto())
                        .setPlanoId(dto.getPlanoId())
                        .build())
                .build();
    }
}
