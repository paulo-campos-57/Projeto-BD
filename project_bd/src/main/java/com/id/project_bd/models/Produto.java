package com.id.project_bd.models;

public class Produto {
    //private int id_produto;
    private int id_produto;
    private int fk_id_user;
    private String nome_produto;
    private String descricao;
    private double preco;

    public Produto(int id_produto, String nome_produto, String descricao, double preco, int fk_id_user) {
        super();
        //this.id_produto = id_produto;
        this.id_produto = id_produto;
        this.nome_produto = nome_produto;
        this.descricao = descricao;
        this.preco = preco;
        this.fk_id_user = fk_id_user;
    }

    public Produto() {
        super();
    }

    public int getFk_id_user(){
        return fk_id_user;
    }

    public void setFk_id_user(int fk_id_user){
        this.fk_id_user = fk_id_user;
    }

    public int getId_produto(){
        return id_produto;
    }

    public void setIdproduto(int id_produto){
        this.id_produto = id_produto;
    }

    public void setNome_produto(String nome_produto){
        this.nome_produto = nome_produto;
    }

    public String getNome_produto(){
        return nome_produto;
    }
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Produto{" +
                "id_produto=" + id_produto +
                ", nome_produto='" + nome_produto + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }

    public void setId_user(int int1) {
        throw new UnsupportedOperationException("Unimplemented method 'setId_user'");
    }
}
