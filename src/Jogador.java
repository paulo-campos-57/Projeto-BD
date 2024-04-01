package src

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
}