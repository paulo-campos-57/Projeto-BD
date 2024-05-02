package com.id.project_bd.models;

public class Jogador extends User {
    private int fk_id_user;
    private Personagem personagem;

    public Jogador(Personagem personagem, int fk_id_user) {
        this.personagem = personagem;
        this.fk_id_user = fk_id_user;
    }

    public Jogador() {
        super();
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
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
                "personagem=" + personagem +
                "fk_id_user=" + fk_id_user +
                '}';
    }
}
