package br.edu.utfpr.md.webapp.model;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Keyword {

    private String nome;

    public Keyword() {
    }

    public Keyword(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
