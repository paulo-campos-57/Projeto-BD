package src.Models;

public class Personagem {
    private String nome;
    private int nivel;
    private String classe;
    private String habilidades;
    private String backstory;


    public Personagem(String nome, int nivel, String classe, String habilidades, String backstory) {
        this.nome = nome;
        this.nivel = nivel;
        this.classe = classe;
        this.habilidades = habilidades;
        this.backstory = backstory;
    }

    public Personagem() {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public String getBackstory() {
        return backstory;
    }

    public void setBackstory(String backstory) {
        this.backstory = backstory;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Personagem{" +
                "nome='" + nome + '\'' +
                ", nivel=" + nivel +
                ", classe='" + classe + '\'' +
                ", habilidades='" + habilidades + '\'' +
                ", backstory='" + backstory + '\'' +
                '}';
    }
}