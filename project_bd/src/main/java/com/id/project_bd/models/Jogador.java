package com.id.project_bd.models;

public class Jogador extends User {
    private int fk_id_user;

    public Jogador(int fk_id_user) {
        this.fk_id_user = fk_id_user;
    }

    public Jogador() {
        super();
    }

    public int getFk_id_user(){
        return fk_id_user;
    }

    public void setFk_id_user(int fk_id_user){
        this.fk_id_user = fk_id_user;
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "Jogador{" +
                "fk_id_user=" + fk_id_user +
                '}';
    }
}
