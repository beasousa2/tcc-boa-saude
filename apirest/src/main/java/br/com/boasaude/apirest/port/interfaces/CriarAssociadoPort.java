package br.com.boasaude.apirest.port.interfaces;

import br.com.boasaude.apirest.adapters.kafka.header.KafkaHeaderDto;
import br.com.boasaude.associado.criar_associado.CriarAssociado;
import br.com.boasaude.associado.criar_associado_resposta.CriarAssociadoResposta;

import java.util.concurrent.ExecutionException;

public interface CriarAssociadoPort {

    CriarAssociadoResposta execute(CriarAssociado avro, KafkaHeaderDto kafkaDto) throws InterruptedException, ExecutionException;
}
