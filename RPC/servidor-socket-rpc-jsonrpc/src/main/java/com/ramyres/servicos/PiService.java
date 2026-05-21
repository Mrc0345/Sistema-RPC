package com.ramyres.servicos;

/*
Pesquise sobre os metodos e escolha um
    * Método de Arquimedes
    * Método de Chudnovsky
    * Método de Leibniz
    * Método de Machin
*/
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PiService implements ServiceInterface {
    @Override
    public String[] Run(String[] params) {
        if (params.length != 1) {
            throw new IllegalArgumentException("Parametros invalidos. Esperado: qtdCasas");
        }

        int qtdCasas = Integer.parseInt(params[0]);
        if (qtdCasas < 0) {
            throw new IllegalArgumentException("A quantidade de casas decimais deve ser positiva");
        }

        int escalaCalculo = qtdCasas + 10;
        BigDecimal pi = arctan(5, escalaCalculo)
                .multiply(BigDecimal.valueOf(16))
                .subtract(arctan(239, escalaCalculo).multiply(BigDecimal.valueOf(4)));

        return new String[]{ pi.setScale(qtdCasas, RoundingMode.HALF_UP).toPlainString() };
    }

    private BigDecimal arctan(int divisor, int escala) {
        BigDecimal resultado = BigDecimal.ZERO;
        BigDecimal x = BigDecimal.ONE.divide(BigDecimal.valueOf(divisor), escala, RoundingMode.HALF_UP);
        BigDecimal xAoQuadrado = x.multiply(x).setScale(escala, RoundingMode.HALF_UP);
        BigDecimal termo = x;
        int denominador = 1;
        boolean somar = true;

        while (termo.compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal parcela = termo.divide(BigDecimal.valueOf(denominador), escala, RoundingMode.HALF_UP);
            resultado = somar ? resultado.add(parcela) : resultado.subtract(parcela);
            termo = termo.multiply(xAoQuadrado).setScale(escala, RoundingMode.HALF_UP);
            denominador += 2;
            somar = !somar;
        }

        return resultado;
    }
}
