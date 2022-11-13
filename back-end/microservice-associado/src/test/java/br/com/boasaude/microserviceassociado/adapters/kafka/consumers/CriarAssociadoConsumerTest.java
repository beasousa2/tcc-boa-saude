//package br.com.boasaude.associado.microservicecore.adapters.kafka.consumers;
//
//import br.com.boasaude.associado.apirest.criar_associado_novo_realizada.*;
//import CriarNovoAssociadoConverter;
//import KafkaHeaderDto;
//import br.com.boasaude.associado.microservicecore.dto.AssociadoDto;
//import EstadoCivil;
//import Genero;
//import Situacao;
//import CriarNovoAssociadoUC;
//import GerarMatricula;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.kafka.support.Acknowledgment;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.UUID;
//
//@RunWith(MockitoJUnitRunner.class)
//public class CriarAssociadoConsumerTest {
//
//    @InjectMocks
//    private CriarAssociadoConsumer consumer;
//    @Mock
//    private CriarNovoAssociadoConverter converter;
//    @Mock
//    private CriarNovoAssociadoUC criarNovoAssociadoUC;
//    @Mock
//    private Acknowledgment acknowledgment;
//
//    private final String transactionId = UUID.randomUUID().toString();
//    private final String correlationId = UUID.randomUUID().toString();
//    private final String topic = "testeTopic";
//
//
//    @Test
//    public void deveProcessarMensagem() {
//        CriaAssociadoNovoRealizada avro = avro();
//        KafkaHeaderDto kafkaHeaderDto = getHeader(transactionId, correlationId);
//
//        Mockito.when(converter.avroToDto(Mockito.any())).thenReturn(associadoDto());
//        consumer.consumer(avro, kafkaHeaderDto.getTransactionId(), topic, kafkaHeaderDto.getCorrelationId(), acknowledgment);
//
//        //Mockito.verify(acknowledgment).acknowledge();
//        Mockito.verify(criarNovoAssociadoUC).execute(Mockito.any());
//    }
//
//    private KafkaHeaderDto getHeader(final String transactionId, final String correlationId) {
//        return KafkaHeaderDto.builder()
//                .transactionId(transactionId)
//                .correlationId(correlationId)
//                .build();
//
//    }
//
//    private CriaAssociadoNovoRealizada avro() {
//        CriaAssociadoNovoRealizada.Builder builder = CriaAssociadoNovoRealizada.newBuilder();
//        builder.setData(
//                CriarAssociadoNovoRealizadaData.newBuilder()
//                        .setInformacoesPessoais(InformacoesPessoais.newBuilder()
//                                .setNomeCompleto("test")
//                                .setDataNascimento("2022-03-21")
//                                .setCpf("02668281245")
//                                .setRg("756382")
//                                .setOrgaoEmissor("PC")
//                                .setDataEmissao("2022-03-21")
//                                .setEmail("beasousa20@outlook.com")
//                                .setTelefone("(91) 98035-9876")
//                                .setEstadoCivil("SOLTEIRO")
//                                .setGenero("FEMININO")
//                                .setSituacao("ATIVO")
//                                .build())
//                        .setEndereco(
//                                Endereco.newBuilder()
//                                        .setBairro("")
//                                        .setCidade("")
//                                        .setCep("")
//                                        .setComplemento("")
//                                        .setNumero("")
//                                        .setLogradouro("")
//                                        .setUf("")
//                                        .build())
//                        .setPlano(Plano.newBuilder()
//                                .setDescricao("plano com apartamento")
//                                .setApartamento(true)
//                                .setEnfermaria(true)
//                                .setOdontologico(true)
//                                .setPrecoMensalidade(200.0)
//                                .build())
//                        .build()
//        );
//        return builder.build();
//    }
//
//    private AssociadoDto associadoDto() {
//        return AssociadoDto.builder()
//                .nome("test")
//                .dataNascimento(LocalDate.now())
//                .cpf("02668281245")
//                .rg("756382")
//                .orgaoEmissor("PC")
//                .dataEmissao(LocalDate.now())
//                .estadoCivil(EstadoCivil.valueOf("SOLTEIRO"))
//                .genero(Genero.valueOf("FEMININO"))
//                .telefone("(91) 98035-9876")
//                .email("beasousa20@outlook.com")
//                .matricula(GerarMatricula.gerarMatricula("02668281245"))
//                .situacao(Situacao.valueOf("ATIVO"))
//                .logradouro("test")
//                .cep("66075220")
//                .numero("24")
//                .complemento("test")
//                .bairro("test")
//                .cidade("test")
//                .uf("CE")
//                .descricao("plano com apartamento")
//                .apartamento(true)
//                .enfermaria(true)
//                .odontologico(true)
//                .precoMensalidade(BigDecimal.valueOf(200.0))
//                .build();
//    }
//
//}