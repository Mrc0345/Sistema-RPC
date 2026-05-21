package com.ramyres.servicos;

public class PalavrasService implements ServiceInterface {

     @Override
    public String[] Run(String[] params) {
        if (params.length != 1) {
            throw new IllegalArgumentException("Parametros invalidos. Esperado: texto");
        }

        String texto = params[0];
        int qtdLetras = 0;
        int qtdVogal = 0;
        int qtdVogalAcentuada = 0;
        int qtdConsoantes = 0;
        int qtdEspacos = 0;
        int qtdPalavrasPar = 0;
        int qtdPalavrasImpar = 0;

        for (int i = 0; i < texto.length(); i++) {
            char caractere = texto.charAt(i);

            if (caractere == ' ') {
                qtdEspacos++;
            }

            if (Character.isLetter(caractere)) {
                qtdLetras++;
                char letra = Character.toLowerCase(caractere);

                if ("aeiou".indexOf(letra) >= 0) {
                    qtdVogal++;
                } else if ("áàâãéèêíìîóòôõúùû".indexOf(letra) >= 0) {
                    qtdVogalAcentuada++;
                } else {
                    qtdConsoantes++;
                }
            }
        }

        String textoSemPontuacao = texto.replaceAll("[^\\p{L}\\s]", " ");
        String[] palavras = textoSemPontuacao.trim().isEmpty()
                ? new String[0]
                : textoSemPontuacao.trim().split("\\s+");

        for (String palavra : palavras) {
            if (palavra.length() % 2 == 0) {
                qtdPalavrasPar++;
            } else {
                qtdPalavrasImpar++;
            }
        }

        int qtdPalavras = palavras.length;
        int qtdDeLinhas = texto.isEmpty() ? 0 : texto.split("\\R", -1).length;

        return new String[]{
            String.valueOf(qtdLetras),
            String.valueOf(qtdPalavras),
            String.valueOf(qtdVogal),
            String.valueOf(qtdVogalAcentuada),
            String.valueOf(qtdConsoantes),
            String.valueOf(qtdEspacos),
            String.valueOf(qtdPalavrasPar),
            String.valueOf(qtdPalavrasImpar),
            String.valueOf(qtdDeLinhas)
        };
    }
}
