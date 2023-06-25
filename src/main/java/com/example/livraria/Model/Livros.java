package com.example.livraria.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Livros {
    @Id
    private int id;
    private String nome;
    private String autor;
    private String data_criacao;

    public Livros(Integer id, String nome, String autor, String data_criacao, String status_livro) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.data_criacao = data_criacao;
        this.status_livro = status_livro;
    }

    private String status_livro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(String data_criacao) {
        this.data_criacao = data_criacao;
    }

    public String getStatus_livro() {
        return status_livro;
    }

    public void setStatus_livro(String status_livro) {
        this.status_livro = status_livro;
    }
}
