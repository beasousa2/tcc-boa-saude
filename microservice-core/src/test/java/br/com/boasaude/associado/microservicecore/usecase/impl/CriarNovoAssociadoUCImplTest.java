package br.com.boasaude.associado.microservicecore.usecase.impl;

import br.com.boasaude.associado.microservicecore.adapters.database.converter.AssociadoConverter;
import br.com.boasaude.associado.microservicecore.adapters.database.entities.Associado;
import br.com.boasaude.associado.microservicecore.dto.CriaAssociadoDto;
import br.com.boasaude.associado.microservicecore.enums.EstadoCivil;
import br.com.boasaude.associado.microservicecore.enums.Genero;
import br.com.boasaude.associado.microservicecore.enums.Situacao;
import br.com.boasaude.associado.microservicecore.ports.interfaces.SalvarAssociadoBancoPort;
import br.com.boasaude.associado.microservicecore.utils.GerarMatricula;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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

    @Test
    public void salvaAssociadoUseCase() {
        Mockito.when(associadoConverter.dtoToEntity(dto)).thenReturn(associado);

        useCase.execute(dto);

        Mockito.verify(port).execute(Mockito.any());
    }

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
                .situacao(Situacao.valueOf("ATIVO"))
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
}