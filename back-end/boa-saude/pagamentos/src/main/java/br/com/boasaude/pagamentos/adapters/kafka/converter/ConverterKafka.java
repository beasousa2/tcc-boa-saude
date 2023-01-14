package br.com.boasaude.pagamentos.adapters.kafka.converter;

import br.com.boasaude.microservicemarcarconsulta.verifica_debito_request.VerificaDebito;
import br.com.boasaude.pagamentos.debito_verificado_reply.DebitoVerificadoReply;
import br.com.boasaude.pagamentos.debito_verificado_reply.DebitoVerificadoReplyData;
import br.com.boasaude.pagamentos.debito_verificado_reply.Pagamentos;
import br.com.boasaude.pagamentos.dto.DebitoAssociadoVerificadoDTO;
import br.com.boasaude.pagamentos.dto.PagamentosDTO;
import br.com.boasaude.pagamentos.dto.VerificarDebitoAssociadoDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ConverterKafka {

   public VerificarDebitoAssociadoDTO avroToDto(VerificaDebito payload) {
       return VerificarDebitoAssociadoDTO.builder()
               .codigoAssociado(payload.getData().getCodigoAssociado().toString())
               .build();

    }

    public DebitoVerificadoReply dtoToAvro(DebitoAssociadoVerificadoDTO dto) {
       return DebitoVerificadoReply.newBuilder()
               .setData(DebitoVerificadoReplyData.newBuilder()
                       .setCodigoAssociado(dto.getCodigoAssociado())
                       .setDebitosAberto(dto.getPagamentos().stream().map(
                               pagamento -> Pagamentos.newBuilder()
                                       .setDataVencimento(pagamento.getDataVencimento().toString())
                                       .setIsPago(pagamento.getIsPago())
                                       .build()

                       ).collect(Collectors.toList()))

                       .build())
               .build();
    }


}
