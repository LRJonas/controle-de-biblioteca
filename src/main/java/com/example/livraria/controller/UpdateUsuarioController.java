package com.example.livraria.controller;

import com.example.livraria.Model.Livros;
import com.example.livraria.Model.Tipo;
import com.example.livraria.Model.Usuario;
import com.example.livraria.service.LivrosService;
import com.example.livraria.service.UsuarioService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "updateUsuario", value = "/updateUsuario")
public class UpdateUsuarioController extends HttpServlet {

    UsuarioService usuarioService = new UsuarioService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        //HttpSession request = null;


        Usuario usuario = null;



        Integer id = Integer.parseInt(req.getParameter("id"));



        try {
            usuario = usuarioService.buscarUm(id);
            req.setAttribute("usuario", usuario);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("editarUsuario.jsp");
        //ServletResponse response = null;
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));
        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");
        String tipo = req.getParameter("tipo");

        Usuario usuario = new Usuario(id, nome, senha, Tipo.valueOf(tipo));

        try {
            usuarioService.Update(usuario);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
