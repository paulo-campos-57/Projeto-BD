package com.id.project_bd.models;

public class Personagem {
    private int id_personagem;
    private String nome;
    private String classe;
    private int nivel;
    private String habilidades;
    private String backstory;
    private int fk_id_jogador;


    public Personagem(int id_personagem, String nome, int nivel, String classe, String habilidades, String backstory, int fk_id_jogador) {
        this.id_personagem = id_personagem;
        this.nome = nome;
        this.nivel = nivel;
        this.classe = classe;
        this.habilidades = habilidades;
        this.backstory = backstory;
        this.fk_id_jogador = fk_id_jogador;
    }

    public int getFk_id_jogador(){
        return fk_id_jogador;
    }

    public void setFk_id_jogador(int fk_id_jogador){
        this.fk_id_jogador = fk_id_jogador;
    }

    public int getId_personagem() {
        return id_personagem;
    }

    public void setId_personagem(int id_personagem) {
        this.id_personagem = id_personagem;
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
