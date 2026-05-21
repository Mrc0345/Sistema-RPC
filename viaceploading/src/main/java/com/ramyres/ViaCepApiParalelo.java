package com.ramyres;

public class ViaCepApiParalelo extends Thread{
    private DtoViaCep dto = null;
    private long cep;

    public ViaCepApiParalelo(long cep){
        this.cep = cep;
    }

    public DtoViaCep getResposta() {
        return dto;
    }

    @Override
    public void run(){
        ViaCepApi api = new ViaCepApi();
        try {
            this.dto = api.buscarCep(this.cep);
        } catch (Exception e) {
        }
    }
}
