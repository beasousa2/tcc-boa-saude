package br.com.boasaude.associado.microservicecore.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Situacao {

    ATIVO("ATIVO", "Usuário ativo no sistema"),
    EM_ANALISE("EM_ANALISE", "Usuário em analise no sistema"),
    SUSPENSO("SUSPENSO", "Usuário suspenso do sistema");


    private String codigo;
    private String descricao;
}
