package com.id.project_bd.models;

public class Denuncia {
    private int fk_id_denuncia;
    private int fk_id_denunciado;
    private String comentario;

    public Denuncia(int fk_id_denuncia, int fk_id_denunciado, String comentario) {
        super();
        this.fk_id_denuncia = fk_id_denuncia;
        this.fk_id_denunciado = fk_id_denunciado;
        this.comentario = comentario;
    }

    public Denuncia() {
        super();
    }

    public int getFk_id_denuncia() {
        return fk_id_denuncia;
    }

    public void setFk_id_denuncia(int fk_id_denuncia) {
        this.fk_id_denuncia = fk_id_denuncia;
    }

    public int getFk_id_denunciado() {
        return fk_id_denunciado;
    }

    public void setFk_id_denunciado(int fk_id_denunciado) {
        this.fk_id_denunciado = fk_id_denunciado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Denuncia{" +
                "fk_id_denuncia=" + fk_id_denuncia +
                ", fk_id_denunciado=" + fk_id_denunciado +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
