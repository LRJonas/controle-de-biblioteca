package com.example.livraria.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
    private Integer id;
    private String nome;

    private String senha;
    private Tipo tipo;


    public Usuario() {
    }

    public Usuario(Integer id, String nome, String senha, Tipo tipo) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
