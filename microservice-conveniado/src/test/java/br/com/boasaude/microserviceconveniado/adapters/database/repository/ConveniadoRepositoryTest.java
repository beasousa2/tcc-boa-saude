package br.com.boasaude.microserviceconveniado.adapters.database.repository;

import br.com.boasaude.microserviceconveniado.adapters.database.entities.Conveniado;
import br.com.boasaude.microserviceconveniado.adapters.database.entities.Endereco;

import br.com.boasaude.microserviceconveniado.adapters.database.entities.Especialidade;
import br.com.boasaude.microserviceconveniado.adapters.database.entities.Procedimento;
import br.com.boasaude.microserviceconveniado.enums.TipoConveniado;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ConveniadoRepositoryTest {

    @Mock
    private ConveniadoRepository repository;
    private Conveniado conveniado;

    @Before
    public void setUp() {
        conveniado = conveniado();
    }

    @Test
    public void retorno() {
        List<Conveniado> conveniados = repository.findByEspecialidades("Hematologia");
        Mockito.verify(repository).findByEspecialidades("Hematologia");
        conveniados.forEach(conv -> assertEquals("teste", conv.getNomeFantasia()));


    }

    @Test
    public void save() {
        repository.save(conveniado);
        Mockito.verify(repository).save(conveniado);
    }

    private List<Especialidade> especialidade() {
        return Collections.singletonList(Especialidade.builder()
                .especialidade("Hematologia")
                .build());
    }

    private List<Procedimento> procedimento() {
        return Collections.singletonList(Procedimento.builder()
                .nomeProcedimento("Consulta")
                .build());
    }

    private Endereco endereco() {
        return Endereco.builder()
                .logradouro("teste")
                .bairro("teste")
                .cep("teste")
                .cidade("teste")
                .complemento("teste")
                .uf("teste")
                .build();
    }



    private Conveniado conveniado() {
        return Conveniado.builder()
                .cnpj("teste")
                .endereco(endereco())
                .especialidades(especialidade())
                .nomeFantasia("teste")
                .tipoConveniado(TipoConveniado.HOSPITAL)
                .razaoSocial("teste")
                .procedimentos(procedimento())
                .build();
    }

}