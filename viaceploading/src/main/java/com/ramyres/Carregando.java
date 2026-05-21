package com.ramyres;

import java.util.concurrent.TimeUnit;

public class Carregando extends Thread{
    private Boolean mostrar = false;

    public void iniciarCarregamento() {
        this.mostrar = true;
        mostrarBloqueante();
    }

    public void finalizarCarregando() {
        this.mostrar = false;
    }

    private void mostrarBloqueante() {
        while (this.mostrar) {
            mostrarGirando();
        }
    }

    private void mostrarGirando() {
        String[] frames = { "|", "/", "-", "\\", "|", "/", "-", "\\" };
        try {
            for (String frame : frames) {
                System.out.print("\b" + frame);
                TimeUnit.MILLISECONDS.sleep(250);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void run(){
        this.iniciarCarregamento();
    }
}
