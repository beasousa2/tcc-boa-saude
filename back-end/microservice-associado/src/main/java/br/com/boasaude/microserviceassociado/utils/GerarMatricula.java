package br.com.boasaude.microserviceassociado.utils;

public class GerarMatricula {

    public static String gerarMatricula(String cpf) {
        String prefix = "88";
        String middle = cpf.substring(0,5);
        int max = 10000;
        int min = 1000;
        int rand = max - min + 2;
        double range = Math.random() * rand;
        return prefix + middle + range;
    }
}
