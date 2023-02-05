package br.com.boasaude.microservicemarcarconsulta.port.impl;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MarcarNovaConsultaPortImplTest {

//    @Mock
//    private MarcarNovaConsultaPort port;
//    @Spy
//    private ConverterKafka converter;
//    @Mock
//    private MarcarNovaConsultaProducer producer;
//    @InjectMocks
//    private MarcarNovaConsultaUCImpl usecase;
//    NovaConsultaForm novaConsulta;
//
//    @Before
//    public void setUp() {
//        novaConsulta = setNovaConsulta();
//    }
//
//    @Test
////    public void executeTesteSucesso() {
////        usecase.execute(novaConsulta);
////        doReturn(setConsulta()).when(converter).formToEntity(setNovaConsulta());
////        doReturn(setConsulta()).when(port).execute(setConsulta());
////        verify(producer).producerSuccess(any(), KafkaHeaderDto.builder().build());
////    }
//
//
//    private NovaConsultaForm setNovaConsulta() {
//        return NovaConsultaForm.builder()
//                .codigoConveniado("teste")
//                .codigoMedico("teste")
//                .dataHora("10/11/2022 10:00")
//                .descricao("teste")
//                .matricula("teste")
//                .build();
//    }
//
//    private Consulta setConsulta() {
//        return Consulta.builder()
//                .descricao("teste")
//                .concluida(false)
//                .codigoConveniado("teste")
//                .dataHora(LocalDateTime.now())
//                .matriculaPaciente("teste")
//                .codigoMedico("teste")
//                .codigoConveniado("teste")
//                .build();
//    }
//
//    private MarcarNovaConsultaResposta setAvro() {
//        return MarcarNovaConsultaResposta.newBuilder()
//                .setData(MarcarNovaConsultaRespostaData.newBuilder()
//                        .setCodigoConveniado("teste")
//                        .setCodigoMedico("teste")
//                        .setDataHora("teste")
//                        .setMatriculaPaciente("teste")
//                        .setDescricao("teste")
//                        .setId(1l)
//                        .build())
//                .build();
//    }
}