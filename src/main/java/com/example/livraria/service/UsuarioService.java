package com.example.livraria.service;

import com.example.livraria.Model.Livros;
import com.example.livraria.Model.Usuario;
import com.example.livraria.repository.UsuarioRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioService {

    UsuarioRepository usuarioRepository = new UsuarioRepository();
    public ArrayList<Usuario> buscarUsuarios(){

        return usuarioRepository.buscarUsuarios();

    }

    public boolean Inserir(Usuario usuario) throws SQLException {

        usuarioRepository.Inserir(usuario);
        return true;
    }

    public boolean Update(Usuario usuario) throws SQLException {

        usuarioRepository.Update(usuario);
        return true;
    }

    public Usuario buscarUm(Integer id) throws SQLException {
        return usuarioRepository.buscarUm(id);

    }

}
