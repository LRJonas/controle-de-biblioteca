package com.example.livraria.controller;

import com.example.livraria.repository.LivrosRepository;
import com.example.livraria.repository.UsuarioRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
@WebServlet(name = "deletarUsuario", value = "/deletarUsuario")
public class DeleteUsuarioController extends HttpServlet {

    UsuarioRepository usuarioRepository = new UsuarioRepository();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("idDel"));
        try {
            usuarioRepository.Delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
