package br.com.boasaude.microserviceassociado.api.services;

import br.com.boasaude.microserviceassociado.adapters.database.converter.ConsultaConverterDatabase;
import br.com.boasaude.microserviceassociado.adapters.database.repository.ConsultaRepository;
import br.com.boasaude.microserviceassociado.adapters.entities.Associado;
import br.com.boasaude.microserviceassociado.adapters.database.repository.AssociadoRepository;
import br.com.boasaude.microserviceassociado.adapters.entities.Consulta;
import br.com.boasaude.microserviceassociado.api.Converter;
import br.com.boasaude.microserviceassociado.api.form.AssociadoForm;
import br.com.boasaude.microserviceassociado.api.form.ConsultaForm;
import br.com.boasaude.microserviceassociado.dto.AssociadoDTO;
import br.com.boasaude.microserviceassociado.dto.ConsultaDto;
import br.com.boasaude.microserviceassociado.dto.CriaAssociadoDto;
import br.com.boasaude.microserviceassociado.dto.DadosAssociadoDto;
import br.com.boasaude.microserviceassociado.usecase.interfaces.CriarNovoAssociadoUC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssociadoService {

    private final AssociadoRepository repository;
    private final ConsultaRepository consultaRepository;
    private final ConsultaConverterDatabase converterConsulta;
    private final Converter converter;

    private final CriarNovoAssociadoUC criarNovoAssociadoUC;
    public DadosAssociadoDto getAssociadoById(String id) {
        Optional<Associado> associado = repository.findById(id);
        return associado.map(converter::associadoToDto).orElse(null);
    }

    public AssociadoDTO getAssociadoByIdComplete(String id) {
        Optional<Associado> associado = repository.findById(id);
        return associado.map(converter::associadoAllToDto).orElse(null);
    }

    public String save(AssociadoForm form) {
        CriaAssociadoDto dto = converter.formToDto(form);
        return criarNovoAssociadoUC.execute(dto);
    }

    public ConsultaDto getConsulta(ConsultaForm form) {
        Optional<Consulta> consulta = consultaRepository.findByMatricula(form.getMatricula());
        return consulta.map(converterConsulta::converter).orElse(null);
    }
}
