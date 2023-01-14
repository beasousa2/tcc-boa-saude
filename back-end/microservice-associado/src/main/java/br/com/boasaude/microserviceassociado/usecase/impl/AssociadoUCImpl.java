package br.com.boasaude.microserviceassociado.usecase.impl;

import br.com.boasaude.associado.criar_associado_resposta.CriarAssociadoResposta;
import br.com.boasaude.microserviceassociado.adapters.database.converter.AssociadoConverter;
import br.com.boasaude.microserviceassociado.adapters.database.entities.Associado;
import br.com.boasaude.microserviceassociado.adapters.api.form.AssociadoForm;
import br.com.boasaude.microserviceassociado.dto.AssociadoDTO;
import br.com.boasaude.microserviceassociado.dto.CriaAssociadoDto;
import br.com.boasaude.microserviceassociado.dto.DadosAssociadoDto;
import br.com.boasaude.microserviceassociado.ports.interfaces.AssociadoPort;
import br.com.boasaude.microserviceassociado.usecase.interfaces.AssociadoUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class AssociadoUCImpl implements AssociadoUC {

    private final AssociadoPort port;
    private final AssociadoConverter converter;

    @Override
    public AssociadoDTO getAssociadoCompleto(String matricula) {
        return port.buscarAssociadoCompleto(matricula);
    }

    @Override
    public DadosAssociadoDto getAssociado(String matricula) {
        return port.buscarAssociadoDados(matricula);
    }


    @Override
    public String salvar(AssociadoForm form) {
        CriaAssociadoDto dto = converter.formToDto(form);
        Associado associado = converter.dtoToEntity(dto);
        return associado.getId();
    }

    @Override
    public List<DadosAssociadoDto> getTodosAssociados() {
        return port.execute();
    }
}
