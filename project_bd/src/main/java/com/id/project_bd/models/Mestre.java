package com.id.project_bd.models;

public class Mestre extends User {
    private int fk_id_user;
    private String npc;
    private String monstro;
    private int numHistorias;

    public Mestre(String npc, String monstro, int fk_id_user) {
        this.npc = npc;
        this.monstro = monstro;
        this.fk_id_user = fk_id_user;
    }

    public Mestre() {
        super();
    }

    public String getNpc() {
        return npc;
    }

    public void setNpc(String npc) {
        this.npc = npc;
    }

    public String getMonstro() {
        return monstro;
    }

    public void setMonstro(String monstro) {
        this.monstro = monstro;
    }

    public int getFk_id_user() {
        return fk_id_user;
    }

    public void setFk_id_user(int fk_id_user) {
        this.fk_id_user = fk_id_user;
    }

    public int getNumHistorias() {
        return numHistorias;
    }

    public void setNumHistorias(int numHistorias) {
        this.numHistorias = numHistorias;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Mestre{" +
                "npc='" + npc + '\'' +
                ", monstro='" + monstro + '\'' +
                ", fk_id_user=" + fk_id_user +
                '}';
    }

}
