package com.id.project_bd.models;

public class User {
    private int id_user;
    private String user_name;
    private String senha;
    private String contato1;
    private String contato2;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;
    private int numHistorias;

    public User(int id_user, String user_name, String senha, String contato1, String contato2, String estado,
            String cidade, String bairro, String rua, String numero, String complemento) {
        super();
        this.id_user = id_user;
        this.user_name = user_name;
        this.senha = senha;
        this.contato1 = contato1;
        this.contato2 = contato2;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public User(int id_user) {
        this.id_user = id_user;
    }

    public User() {
        super();
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getContato1() {
        return contato1;
    }

    public void setContato1(String contato1) {
        this.contato1 = contato1;
    }

    public String getContato2() {
        return contato2;
    }

    public void setContato2(String contato2) {
        this.contato2 = contato2;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumHistorias() {
        return numHistorias;
    }

    public void setNumHistorias(int numHistorias) {
        this.numHistorias = numHistorias;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
                ", user_name='" + user_name + '\'' +
                ", senha='" + senha + '\'' +
                ", contato1='" + contato1 + '\'' +
                ", contato2='" + contato2 + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                '}';
    }
}
