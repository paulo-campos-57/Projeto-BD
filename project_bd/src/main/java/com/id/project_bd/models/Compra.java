package com.id.project_bd.models;

import java.sql.Date;

public class Compra extends User {
    private int id_compra;
    private int fk_id_produto;
    private int fk_id_user;
    private Date data_compra;

    public Compra(int id_compra, Date data_compra, int fk_id_produto, int fk_id_user) {
        this.id_compra = id_compra;
        this.data_compra = data_compra;
        this.fk_id_produto = fk_id_produto;
        this.fk_id_user = fk_id_user;
    }

    public Compra() {
        super();
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
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


    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Compra{" +
                ", id_compra=" + id_compra +
                ", fk_id_produto=" + fk_id_produto + 
                ", fk_id_user=" + fk_id_user +
                ", data_compra='" + data_compra + '\'' +
                '}';
    }
}
