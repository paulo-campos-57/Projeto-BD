package com.id.project_bd.models;

public class Dado extends Produto {
    private int fk_id_produto;
    private int qtd_lados;

    public Dado(int fk_id_produto, int qtd_lados) {
        this.fk_id_produto = fk_id_produto;
        this.qtd_lados = qtd_lados;
    }

    public Dado() {
        super();
    }

    public int getFk_id_produto() {
        return fk_id_produto;
    }

    public void setFk_id_produto(int fk_id_produto) {
        this.fk_id_produto = fk_id_produto;
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
                "fk_id_produto=" + fk_id_produto +
                ", qtd_lados=" + qtd_lados +
                '}';
    }
}
