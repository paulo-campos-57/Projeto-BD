package models;

public class User {
    private int id;
    private String nome_usuario;
    private String email;
    private String senha;
    private String contato;
    private Endereco end;

    public User(int id, String nome_usuario, String email, String senha, String contato, Endereco end) {
        this.id = id;
        this.nome_usuario = nome_usuario;
        this.email = email;
        this.senha = senha;
        this.contato = contato;
        this.end = end;
    }

    public User() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Endereco getEnd() {
        return end;
    }

    public void setEnd(Endereco end) {
        this.end = end;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "id=" + id +
                ", nome_usuario='" + nome_usuario + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", contato='" + contato + '\'' +
                ", end=" + end +
                '}';
    }
}
