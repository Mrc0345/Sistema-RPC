package com.ramyres;

public class Main {
    public static void main(String[] args) {
        // Utilizando herança Thread
        CozinheiroThread c1 = new CozinheiroThread("Alex Atala");
        CozinheiroThread c2 = new CozinheiroThread("Manu Bufara");
        CozinheiroThread c3 = new CozinheiroThread("Jeferson Rueda");

        c1.start();
        c2.start();
        c3.start();

        // Utilizando implementação da interface Runnable
        Thread t1 = new Thread(new CozinheiroRunnable("Érick Jacquin"));
        Thread t2 = new Thread(new CozinheiroRunnable("Paola Carosella"));
        Thread t3 = new Thread(new CozinheiroRunnable("Henrique Fogaça"));
    
        t1.start();
        t2.start();
        t3.start();
    }
}