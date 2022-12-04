package br.com.boasaude.microserviceassociado.ports.impl;

import br.com.boasaude.associado.criar_associado_resposta.CriarAssociadoResposta;
import br.com.boasaude.microserviceassociado.adapters.database.converter.AssociadoConverter;
import br.com.boasaude.microserviceassociado.adapters.database.repository.AssociadoRepository;
import br.com.boasaude.microserviceassociado.adapters.database.entities.Associado;
import br.com.boasaude.microserviceassociado.dto.AssociadoDTO;
import br.com.boasaude.microserviceassociado.dto.DadosAssociadoDto;
import br.com.boasaude.microserviceassociado.enums.Situacao;
import br.com.boasaude.microserviceassociado.ports.interfaces.AssociadoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AssociadoPortImpl implements AssociadoPort {

    private final AssociadoRepository repository;
    private final AssociadoConverter converter;

    @Override
    public AssociadoDTO buscarAssociadoCompleto(String id) {
        Optional<Associado> associado = repository.findById(id);
        return associado.map(converter::converterComplete).orElse(null);
    }

    @Override
    public DadosAssociadoDto buscarAssociadoDados(String id) {
        Optional<Associado> associado = repository.findById(id);
        return associado.map(converter::converterData).orElse(null);
    }

    @Override
    public CriarAssociadoResposta execute(Associado associado) {
        Associado result = repository.save(associado);
        return converter.entityToAvro(result);
    }

    @Override
    public List<DadosAssociadoDto> execute() {
        List<Associado> associados = repository.findAll();
        List<DadosAssociadoDto> dados = new ArrayList<DadosAssociadoDto>();
        return associados.stream().map(associado -> DadosAssociadoDto.builder()
                .id(associado.getId())
                .status(Situacao.valueOf(associado.getSituacao()))
                .email(associado.getEmail())
                .nome(associado.getNome())
                .matricula(associado.getMatricula())
                .build()).collect(Collectors.toList());
    }
}
