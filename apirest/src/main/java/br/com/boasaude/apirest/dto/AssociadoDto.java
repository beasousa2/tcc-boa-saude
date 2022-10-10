package br.com.boasaude.apirest.dto;

import br.com.boasaude.apirest.enums.EstadoCivil;
import br.com.boasaude.apirest.enums.Genero;
import br.com.boasaude.apirest.enums.Situacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.avro.generic.GenericRecord;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AssociadoDto {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String rg;
    private String orgaoEmissor;
    private LocalDate dataEmissao;
    private String matricula;
    private String telefone;
    private String email;
    private EstadoCivil estadoCivil;
    private Genero genero;
    private Situacao situacao;
    private PlanoDto plano;
    private EnderecoDto endereco;


}
