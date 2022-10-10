package br.com.boasaude.microserviceassociado.usecase.impl;

import br.com.boasaude.microserviceassociado.adapters.database.converter.AssociadoConverter;
import br.com.boasaude.microserviceassociado.adapters.entities.Associado;
import br.com.boasaude.microserviceassociado.dto.CriaAssociadoDto;
import br.com.boasaude.microserviceassociado.dto.EnderecoDto;
import br.com.boasaude.microserviceassociado.dto.InformacoesPessoaisDto;
import br.com.boasaude.microserviceassociado.dto.PlanoDto;
import br.com.boasaude.microserviceassociado.enums.EstadoCivil;
import br.com.boasaude.microserviceassociado.enums.Genero;
import br.com.boasaude.microserviceassociado.enums.Situacao;
import br.com.boasaude.microserviceassociado.ports.interfaces.SalvarAssociadoBancoPort;
import br.com.boasaude.microserviceassociado.utils.GerarMatricula;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDate;


@RunWith(MockitoJUnitRunner.class)
public class CriarNovoAssociadoUCImplTest {

    @InjectMocks
    private CriarNovoAssociadoUCImpl useCase;
    @Mock
    private SalvarAssociadoBancoPort port;
    @Mock
    private AssociadoConverter associadoConverter;
    private CriaAssociadoDto dto;
    private Associado associado;


    @Before
    public void setUp(){
        dto = setAssociadoDto();
        associado = setAssociado();
    }

//    @Test
//    public void salvaAssociadoUseCase() {
//        Mockito.when(associadoConverter.dtoToEntity(dto)).thenReturn(associado);
//        String transactionId = UUID.randomUUID().toString();
//        String correlationId = UUID.randomUUID().toString();
//        String topico = "topicoConsumer";
//        KafkaHeaderDto headers = KafkaHeader.retrieveHeader(transactionId, topico, correlationId, "Criar novo associado no banco de dados");
//        useCase.execute(dto, headers);
//
//        Mockito.verify(port).execute(Mockito.any());
//    }

    private Associado setAssociado() {
        return Associado.builder()
                .nome("teste")
                .dataNascimento(LocalDate.now())
                .cpf("02668281245")
                .rg("756382")
                .orgaoEmissor("PC")
                .dataEmissao(LocalDate.now())
                .estadoCivil("SOLTEIRO")
                .genero("FEMININO")
                .telefone("(91) 98035-9876")
                .email("beasousa20@outlook.com")
                .matricula(GerarMatricula.gerarMatricula("02668281245"))
                .situacao("ATIVO")
                .logradouro("teste")
                .cep("66075220")
                .numero("24")
                .complemento("teste")
                .bairro("teste")
                .cidade("teste")
                .uf("CE")
                .descricao("plano com apartamento")
                .apartamento(true)
                .enfermaria(true)
                .odontologico(true)
                .precoMensalidade(BigDecimal.valueOf(200.0))
                .build();
    }

    private CriaAssociadoDto setAssociadoDto() {
        return CriaAssociadoDto.builder()
                .infoPessoaisDto(InformacoesPessoaisDto.builder()
                        .nome("teste")
                        .dataNascimento(LocalDate.now())
                        .cpf("02668281245")
                        .rg("756382")
                        .orgaoEmissor("PC")
                        .dataEmissao(LocalDate.now())
                        .estadoCivil(EstadoCivil.valueOf("SOLTEIRO"))
                        .genero(Genero.valueOf("FEMININO"))
                        .telefone("(91) 98035-9876")
                        .email("beasousa20@outlook.com")
                        .matricula(GerarMatricula.gerarMatricula("02668281245"))
                        .situacao(Situacao.valueOf("ATIVO")).build())
                .enderecoDto(EnderecoDto.builder()
                        .logradouro("teste")
                        .cep("66075220")
                        .numero("24")
                        .complemento("teste")
                        .bairro("teste")
                        .cidade("teste")
                        .uf("CE")
                        .build())
                .planoDto(PlanoDto.builder()
                        .descricao("plano com apartamento")
                        .apartamento(true)
                        .enfermaria(true)
                        .odontologico(true)
                        .precoMensalidade(BigDecimal.valueOf(200.0))
                        .build())
                .build();
    }
}