package com.id.project_bd.models;

import java.sql.Date;

public class Historia {
    private int id_historia;
    private String nome;
    private String prologo;
    private int qtd_jogadores;
    private Date dt_inicio;
    private boolean presencial;
    private int fk_id_mestre;

    public Historia(int id_historia, String nome, String prologo, int qtd_jogadores, Date dt_inicio, boolean presencial, Mestre mestre, Personagem personagens, int fk_id_mestre) {
        this.id_historia = id_historia;
        this.nome = nome;
        this.prologo = prologo;
        this.qtd_jogadores = qtd_jogadores;
        this.dt_inicio = dt_inicio;
        this.presencial = presencial;
        this.fk_id_mestre = fk_id_mestre;
    }

    public Historia() {
        super();
    }

    public int getId_historia() {
        return id_historia;
    }

    public void setId_historia(int id_historia) {
        this.id_historia = id_historia;
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

    public Date getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(Date date) {
        this.dt_inicio = date;
    }

    public boolean isPresencial() {
        return presencial;
    }

    public void setPresencial(boolean presencial) {
        this.presencial = presencial;
    }

    public int getFk_id_mestre(){
        return fk_id_mestre;
    }

    public void setFk_id_mestre(int fk_id_mestre){
        this.fk_id_mestre = fk_id_mestre;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Historia{" +
                "id_historia=" + id_historia +
                ", nome='" + nome + '\'' +
                ", prologo=" + prologo +
                ", qtd_jogadores=" + qtd_jogadores +
                ", dt_inicio=" + dt_inicio +
                ", presencial=" + presencial +
                ", fk_id_mestre=" + fk_id_mestre +
                '}';
    }
}
