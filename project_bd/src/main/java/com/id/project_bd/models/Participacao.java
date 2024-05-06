package com.id.project_bd.models;

public class Participacao {
    private int fk_id_personagem;
    private int fk_id_mestre;
    private int fk_id_historia;

    public Participacao(int fk_id_personagem, int fk_id_mestre, int fk_id_historia){
        this.fk_id_personagem = fk_id_personagem;
        this.fk_id_mestre = fk_id_mestre;
        this.fk_id_historia = fk_id_historia;
    }

    public Participacao(){
        super();
    }

    public int getfk_id_personagem(){
        return fk_id_personagem;
    }

    public void setfk_id_personagem(int fk_id_personagem){
        this.fk_id_personagem = fk_id_personagem;
    }

    public int getfk_id_mestre(){
        return fk_id_mestre;
    }

    public void setfk_id_mestre(int fk_id_mestre){
        this.fk_id_mestre = fk_id_mestre;
    }

    public int getfk_id_historia(){
        return fk_id_historia;
    }

    public void setfk_id_historia(int fk_id_historia){
        this.fk_id_historia = fk_id_historia;
    }
}
