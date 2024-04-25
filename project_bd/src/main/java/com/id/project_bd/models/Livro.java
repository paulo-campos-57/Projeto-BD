package com.id.project_bd.models;

public class Livro extends Produto {
    private int qtd_paginas;
    private int estado;
    /*
     * Vamos ter uma escala de 1 a 5 para julgar o estado do livro. Por isso estado é uma variável inteira
     */


    public Livro(int qtd_paginas, int estado) {
        this.qtd_paginas = qtd_paginas;
        this.estado = estado;
    }

    public Livro() {
        super();
    }

    public int getQtd_paginas() {
        return qtd_paginas;
    }

    public void setQtd_paginas(int qtd_paginas) {
        this.qtd_paginas = qtd_paginas;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Livro{" +
                "qtd_paginas=" + qtd_paginas +
                ", estado=" + estado +
                '}';
    }
}
