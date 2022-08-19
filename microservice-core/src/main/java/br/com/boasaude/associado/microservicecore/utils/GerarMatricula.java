package br.com.boasaude.associado.microservicecore.utils;

public class GerarMatricula {

    public static String gerarMatricula(String cpf) {
        String prefix = "8845";
        String middle = cpf.substring(0,5);
        String end = Math.random() + "-12";

        return prefix + middle + end;
    }
}
