package br.edu.utfpr.md.webapp.model;

public class Pessoa {
    private String nome;
    private String usuario;
    private String senha;
    
    public Pessoa(){
        
    }

    public Pessoa(String nome, String login, String senha) {
        this.nome = nome;
        this.usuario = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.usuario = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
