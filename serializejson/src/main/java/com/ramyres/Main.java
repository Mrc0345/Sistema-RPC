package com.ramyres;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Pessoa p = new Pessoa("Jhon Travolta", 71);

        Gson g = new Gson();
        
        System.out.println(g.toJson(p));
    }
}

class Pessoa{
    private String name;
    private int idade;

    public Pessoa(String n, int i){
        this.name = n;
        this.idade = i;
    }
}