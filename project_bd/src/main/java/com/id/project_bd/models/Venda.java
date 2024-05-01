package com.id.project_bd.models;
import java.sql.Date;
public class Venda extends User{
    private int id_venda;
    private int id_produto;
    private Date dataVenda;
    public Venda(int id_venda,int id_produto,int id_user,Date dataVenda){
        super(id_user);
        this.id_venda=id_venda;
        this.id_produto=id_produto;
        this.dataVenda=dataVenda;
    }
    public Venda(){
        super();
    }
    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
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
                ", id produto='" + id_produto + '\'' +
                ", data='" + dataVenda + '\'' +
                '}';
    }
}    

