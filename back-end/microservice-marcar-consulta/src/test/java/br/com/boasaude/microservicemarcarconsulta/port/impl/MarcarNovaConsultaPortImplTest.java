package br.com.boasaude.microservicemarcarconsulta.port.impl;

import br.com.boasaude.microservicemarcarconsulta.adapters.api.form.NovaConsultaForm;
import br.com.boasaude.microservicemarcarconsulta.adapters.database.entity.Consulta;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.converters.MarcarNovaConsultaConverter;
import br.com.boasaude.microservicemarcarconsulta.adapters.kafka.producers.MarcarNovaConsultaProducer;
import br.com.boasaude.microservicemarcarconsulta.marcar_nova_consulta_resposta.MarcarNovaConsultaResposta;
import br.com.boasaude.microservicemarcarconsulta.marcar_nova_consulta_resposta.MarcarNovaConsultaRespostaData;
import br.com.boasaude.microservicemarcarconsulta.port.interfaces.MarcarNovaConsultaPort;
import br.com.boasaude.microservicemarcarconsulta.usecase.impl.MarcarNovaConsultaUCImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MarcarNovaConsultaPortImplTest {

    @Mock
    private MarcarNovaConsultaPort port;
    @Spy
    private MarcarNovaConsultaConverter converter;
    @Mock
    private MarcarNovaConsultaProducer producer;
    @InjectMocks
    private MarcarNovaConsultaUCImpl usecase;
    NovaConsultaForm novaConsulta;

    @Before
    public void setUp() {
        novaConsulta = setNovaConsulta();
    }

    @Test
//    public void executeTesteSucesso() {
//        usecase.execute(novaConsulta);
//        doReturn(setConsulta()).when(converter).formToEntity(setNovaConsulta());
//        doReturn(setConsulta()).when(port).execute(setConsulta());
//        verify(producer).producerSuccess(any(), KafkaHeaderDto.builder().build());
//    }


    private NovaConsultaForm setNovaConsulta() {
        return NovaConsultaForm.builder()
                .codigoConveniado("teste")
                .codigoMedico("teste")
                .dataHora(LocalDateTime.now())
                .descricao("teste")
                .matricula("teste")
                .build();
    }

    private Consulta setConsulta() {
        return Consulta.builder()
                .descricao("teste")
                .concluida(false)
                .codigoConveniado("teste")
                .dataHora(LocalDateTime.now())
                .matriculaPaciente("teste")
                .codigoMedico("teste")
                .codigoConveniado("teste")
                .build();
    }

    private MarcarNovaConsultaResposta setAvro() {
        return MarcarNovaConsultaResposta.newBuilder()
                .setData(MarcarNovaConsultaRespostaData.newBuilder()
                        .setCodigoConveniado("teste")
                        .setCodigoMedico("teste")
                        .setDataHora("teste")
                        .setMatriculaPaciente("teste")
                        .setDescricao("teste")
                        .setId(1l)
                        .build())
                .build();
    }
}