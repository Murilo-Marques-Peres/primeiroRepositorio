package com.example.mymeds;

import java.io.Serializable;

public class Dados implements Serializable {
    private int id;
    private int numero;
    private int dose;
    private String nome;
    private int numeroDezem;

    public int getNumeroDezem() {
        return numeroDezem;
    }

    public void setNumeroDezem(int numeroDezem) {
        this.numeroDezem = numeroDezem;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(Integer dose) {
        this.dose = dose;
    }

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
