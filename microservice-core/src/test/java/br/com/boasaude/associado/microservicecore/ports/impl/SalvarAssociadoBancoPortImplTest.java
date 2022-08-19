package br.com.boasaude.associado.microservicecore.ports.impl;

import br.com.boasaude.associado.microservicecore.adapters.database.entities.Associado;
import br.com.boasaude.associado.microservicecore.adapters.database.repository.AssociadoRepository;
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
        salvarAssociadoBancoPort.execute(associado);
        Mockito.verify(repository).save(Mockito.any());
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