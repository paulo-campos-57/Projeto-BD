package com.id.project_bd.models;
import java.sql.Date;
public class Compra extends User{
    private int id_compra;
    private Produto id_produto;
    private Date data_compra;
    public Compra(int id_compra,Produto id_produto,int id_user,Date data_compra){
        super(id_user);
        this.id_compra=id_compra;
        this.id_produto=id_produto;
        this.data_compra=data_compra;
    }
    public Compra(){
        super();
    }
    public int getId_compra(){
        return id_compra;
    }
    public void setId_compra(int id_compra){
        this.id_compra=id_compra;
    }
    public Produto getId_produto(){
        return id_produto;
    }
    public void setId_produto(Produto id_produto){
        this.id_produto=id_produto;
    }
    public Date getData_compra(){
        return data_compra;
    }
    public void setData_compra(Date data_compra){
        this.data_compra=data_compra;
    }
    @java.lang.Override
    public java.lang.String toString() {
        return "Compra{" +
                ", id compra=" + id_compra +
                ", id produto='" + id_produto + '\'' +
                ", data='" + data_compra + '\'' +
                '}';
    }
}
