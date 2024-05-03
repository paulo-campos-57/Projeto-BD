package com.id.project_bd.models;

import java.sql.Date;

public class Venda extends User {
    private int id_venda;
    private int fk_id_produto;
    private int fk_id_user;
    private Date dataVenda;

    public Venda(int id_venda, int fk_id_produto, int fk_id_user, Date dataVenda) {
        this.id_venda = id_venda;
        this.fk_id_produto = fk_id_produto;
        this.fk_id_user = fk_id_user;
        this.dataVenda = dataVenda;
    }

    public Venda() {
        super();
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public int getFk_id_produto(){
        return fk_id_produto;
    }

    public void setFk_id_produto(int fk_id_produto){
        this.fk_id_produto = fk_id_produto;
    }

    public int getFk_id_user(){
        return fk_id_user;
    }

    public void setFk_id_user(int fk_id_user){
        this.fk_id_user = fk_id_user;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Venda{" +
                ", id venda=" + id_venda +
                ", fk_id_produto='" + fk_id_produto + '\'' +
                ", fk_id_user='" + fk_id_user + '\'' +
                ", data='" + dataVenda + '\'' +
                '}';
    }
}
