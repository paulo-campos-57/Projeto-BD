package com.id.project_bd.models;

public class Livro extends Produto {
    private int fk_id_produto;
    private int qtd_paginas;
    private double estado;
    //private Produto produto;
    /*
     * Vamos ter uma escala de 1 a 5 para julgar o estado do livro. Por isso estado é uma variável inteira
     */


    public Livro(int qtd_paginas, int estado, int fk_id_produto) {
        this.qtd_paginas = qtd_paginas;
        this.estado = estado;
        this.fk_id_produto = fk_id_produto;
    }

    public Livro() {
        super();
    }

    public int getFk_id_produto() {
        return fk_id_produto;
    }

    public void setFk_id_produto(int fk_id_produto) {
        this.fk_id_produto = fk_id_produto;
    }

    public int getQtd_paginas() {
        return qtd_paginas;
    }

    public void setQtd_paginas(int qtd_paginas) {
        this.qtd_paginas = qtd_paginas;
    }

    public double getEstado() {
        return estado;
    }

    public void setEstado(double d) {
        this.estado = d;
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "Livro{" +
                "fk_id_produto" + fk_id_produto +
                "qtd_paginas=" + qtd_paginas +
                ", estado=" + estado +
                '}';
    }
}
