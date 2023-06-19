package com.example.mymeds;

import java.io.Serializable;

public class Dados implements Serializable {
    private int id;
    private int numero;

    public int getDose() {
        return dose;
    }

    public void setDose(Integer dose) {
        this.dose = dose;
    }

    private int dose;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
