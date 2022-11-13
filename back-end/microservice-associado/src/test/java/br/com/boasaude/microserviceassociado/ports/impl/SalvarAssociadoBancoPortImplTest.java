package br.com.boasaude.microserviceassociado.ports.impl;

import br.com.boasaude.associado.criar_associado_resposta.CriarAssociadoResposta;
import br.com.boasaude.microserviceassociado.adapters.entities.Associado;
import br.com.boasaude.microserviceassociado.adapters.database.repository.AssociadoRepository;
import br.com.boasaude.microserviceassociado.utils.GerarMatricula;
import org.junit.Assert;
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
public class SalvarAssociadoBancoPortImplTest {

    @InjectMocks
    private SalvarAssociadoBancoPortImpl salvarAssociadoBancoPort;
    @Mock
    private AssociadoRepository repository;

    private Associado associado;

    @Before
    public void setUp() {
        associado = setAssociado();
    }

    @Test
    public void salvaAssociadoNoBanco() {
        CriarAssociadoResposta resposta = salvarAssociadoBancoPort.execute(associado);
        Mockito.verify(repository).save(Mockito.any());
        Assert.assertEquals("teste", resposta.getData().getNomeCompleto());
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

}