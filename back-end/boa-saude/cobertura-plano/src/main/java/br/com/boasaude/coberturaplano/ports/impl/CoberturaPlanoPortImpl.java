package br.com.boasaude.coberturaplano.ports.impl;

import br.com.boasaude.coberturaplano.adapters.database.entities.Cobertura;
import br.com.boasaude.coberturaplano.adapters.database.entities.CoberturaPlano;
import br.com.boasaude.coberturaplano.adapters.database.repositories.CoberturaPlanoRepository;
import br.com.boasaude.coberturaplano.dto.CoberturaPlanoVerificadoDTO;
import br.com.boasaude.coberturaplano.dto.VerificaCoberturaPlanoDto;
import br.com.boasaude.coberturaplano.ports.interfaces.CoberturaPlanoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CoberturaPlanoPortImpl implements CoberturaPlanoPort {

    private final CoberturaPlanoRepository repository;

    @Override
    public CoberturaPlanoVerificadoDTO verificar(VerificaCoberturaPlanoDto dto) {
        Cobertura cobertura = returnCobertura(dto.getProcedimento());
        Optional<CoberturaPlano> coberturaAtiva = repository.findByCoberturaDescricaoAndIsAssociadoAtivo(dto.getAssociadoId(), cobertura);
        return coberturaAtiva.map(coberturaPlano -> CoberturaPlanoVerificadoDTO.builder()
                .planoId(coberturaPlano.getPlanoId())
                .isCoberto(Boolean.TRUE)
                .associadoId(coberturaPlano.getAssociadoId())
                .build()).orElse(null);

    }

    private Cobertura returnCobertura(String procedimento) {
       return Cobertura.builder().descricao(procedimento).build();
    }
}
