package br.edu.utfpr.md.webapp.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Documento {

    @Id
    private ObjectId id;

    @NotNull(message = "descricao não pode ser nulo!!")
    private String descricao;

    private String data;
    private String ultatualizacao;
    private String nome;

    public List<Keyword> keyword = new ArrayList<>();

    //@Reference
    static Categoria[] categoria = new Categoria[3];

    //categoria[0] = new Categoria();
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<Keyword> getKeyword() {
        return keyword;
    }

    public void setKeyword(List<Keyword> keyword) {
        this.keyword = keyword;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUltatualizacao() {
        return ultatualizacao;
    }

    public void setUltatualizacao(String ultatualizacao) {
        this.ultatualizacao = ultatualizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
