package br.com.boasaude.microserviceassociado.ports.interfaces;

import br.com.boasaude.associado.criar_associado_resposta.CriarAssociadoResposta;
import br.com.boasaude.microserviceassociado.adapters.database.entities.Associado;
import br.com.boasaude.microserviceassociado.dto.AssociadoDTO;
import br.com.boasaude.microserviceassociado.dto.DadosAssociadoDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AssociadoPort {

    AssociadoDTO buscarAssociadoCompleto(String id);
    DadosAssociadoDto buscarAssociadoDados(String id);

    CriarAssociadoResposta execute(Associado associado);

    List<DadosAssociadoDto> execute();


}
