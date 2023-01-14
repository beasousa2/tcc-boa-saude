package br.com.boasaude.pagamentos.ports.impl;

import br.com.boasaude.pagamentos.adapters.database.entities.Associado;
import br.com.boasaude.pagamentos.adapters.database.repository.AssociadoRepository;
import br.com.boasaude.pagamentos.dto.DebitoAssociadoVerificadoDTO;
import br.com.boasaude.pagamentos.dto.PagamentosDTO;
import br.com.boasaude.pagamentos.ports.interfaces.AssociadoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AssociadoPortImpl implements AssociadoPort {

    private final AssociadoRepository repository;
    @Override
    public DebitoAssociadoVerificadoDTO verificarDebitos(String codigoAssociado, Boolean isPago) {
        Associado associado = repository.findByCodigoAssociadoAndPagamentosIsPago(codigoAssociado, isPago);
        return DebitoAssociadoVerificadoDTO.builder()
                .codigoAssociado(associado.getCodigoAssociado())
                .pagamentos(associado.getPagamentos()
                        .stream().map(pagamento ->
                                PagamentosDTO.builder()
                                        .isPago(pagamento.getIsPago())
                                        .dataVencimento(pagamento.getDataVencimento())
                                        .build()).collect(Collectors.toList()))
                .build();
    }
}
