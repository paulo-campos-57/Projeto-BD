package com.id.project_bd.models;

import java.time.LocalDate;

public class Historia {
    private int id;
    private String nome;
    private String prologo;
    private int qtd_jogadores;
    private LocalDate dt_inicio;
    private boolean presencial;
    private Mestre mestre;
    private Personagem personagens;

    public Historia(int id, String nome, String prologo, int qtd_jogadores, LocalDate dt_inicio, boolean presencial, Mestre mestre, Personagem personagens) {
        this.id = id;
        this.nome = nome;
        this.prologo = prologo;
        this.qtd_jogadores = qtd_jogadores;
        this.dt_inicio = dt_inicio;
        this.presencial = presencial;
        this.mestre = mestre;
        this.personagens = personagens;
    }

    public Historia() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrologo() {
        return prologo;
    }

    public void setPrologo(String prologo) {
        this.prologo = prologo;
    }

    public int getQtd_jogadores() {
        return qtd_jogadores;
    }

    public void setQtd_jogadores(int qtd_jogadores) {
        this.qtd_jogadores = qtd_jogadores;
    }

    public LocalDate getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(LocalDate dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    public boolean isPresencial() {
        return presencial;
    }

    public void setPresencial(boolean presencial) {
        this.presencial = presencial;
    }

    public Mestre getMestre() {
        return mestre;
    }

    public void setMestre(Mestre mestre) {
        this.mestre = mestre;
    }

    public Personagem getPersonagens() {
        return personagens;
    }

    public void setPersonagens(Personagem personagens) {
        this.personagens = personagens;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Historia{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", prologo=" + prologo +
                ", qtd_jogadores=" + qtd_jogadores +
                ", dt_inicio=" + dt_inicio +
                ", presencial=" + presencial +
                ", mestre=" + mestre +
                ", personagens=" + personagens +
                '}';
    }
}
