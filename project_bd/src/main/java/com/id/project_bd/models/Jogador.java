package com.id.project_bd.models;

public class Jogador extends User {
    private Personagem personagem;

    public Jogador(Personagem personagem) {
        this.personagem = personagem;
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

    @java.lang.Override
    public java.lang.String toString() {
        return "Jogador{" +
                "personagem=" + personagem +
                '}';
    }
}
