package com.ramyres;

public class CozinheiroRunnable implements Runnable{
    private String nome;

    public CozinheiroRunnable(String n){
        this.nome = n;
    }
    
    @Override
    public void run() {
        String txt = "Cozinheiro "+nome+" cozinhando! ";
        System.out.println(txt+Thread.currentThread().getName());
    }
}
