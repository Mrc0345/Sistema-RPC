package com.ramyres;

public class Main {
    private static void buscaCepAssincrono(long cep) {
        DtoViaCep resposta = null;
        ViaCepApiParalelo api = new ViaCepApiParalelo(cep);
        api.start();

        Carregando carregando = new Carregando();
        carregando.start();

        // TODO:
        // ATIVIDADE: Corrigir método para não mostrar o carregamento enquanto
        // busca os dados, ao final, deve finalizar o carregamento e mostrar
        // as informações.


        // Retorno
        mostrarInformacoesCep(resposta);
    }

    private static void buscaCepSincrono(long cep) {
        ViaCepApi api = new ViaCepApi();
        try {
            DtoViaCep resposta = api.buscarCep(cep);
            mostrarInformacoesCep(resposta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarInformacoesCep(DtoViaCep cepInfo) {
        if (cepInfo == null)
            return;

        System.out.println("------ Endereço -------");
        System.out.println("Rua: " + cepInfo.getLogradouro());
        System.out.println("Complemento: " + cepInfo.getComplemento());
        System.out.println("Bairro: " + cepInfo.getBairro());
        System.out.println("Cidade: " + cepInfo.getLocalidade());
        System.out.println("Estado: " + cepInfo.getEstado());
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            String arg = args[0].toString();
            Long cep = Long.valueOf(arg);
            buscaCepAssincrono(cep);
        } else {
            buscaCepAssincrono(74730120);
        }
    }
}