package com.ramyres;

public class CozinheiroThread extends Thread{
    private String nome;

    public CozinheiroThread(String n){
        this.nome = n;
    }

    public void run(){
        String txt = "Cozinheiro "+nome+" cozinhando! ";
        System.out.println(txt+Thread.currentThread().getName());
    }
}
