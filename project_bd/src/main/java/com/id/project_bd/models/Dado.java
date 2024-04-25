package com.id.project_bd.models;

public class Dado extends Produto {
    private int qtd_lados;

    public Dado(int qtd_lados) {
        this.qtd_lados = qtd_lados;
    }

    public Dado() {
        super();
    }

    public int getQtd_lados() {
        return qtd_lados;
    }

    public void setQtd_lados(int qtd_lados) {
        this.qtd_lados = qtd_lados;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Dado{" +
                "qtd_lados=" + qtd_lados +
                '}';
    }
}
