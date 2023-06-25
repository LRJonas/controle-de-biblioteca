package com.example.livraria.service;

import com.example.livraria.Model.Livros;
import com.example.livraria.repository.LivrosRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class LivrosService {

    LivrosRepository livrosRepository = new LivrosRepository();
    public ArrayList<Livros> buscarLivros(){



        return livrosRepository.getLivros();

    }

    public boolean Inserir(Livros livro) throws SQLException {

        livrosRepository.Inserir(livro);
        return true;
    }
    public boolean Update(Livros livro) throws SQLException {

        livrosRepository.Update(livro);
        return true;
    }
    public Livros buscarUm(Integer id) throws SQLException {
        return livrosRepository.buscarUm(id);

    }
}
