package com.example.livraria.controller;

import com.example.livraria.Model.Livros;
import com.example.livraria.Model.Tipo;
import com.example.livraria.Model.Usuario;
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
@WebServlet(name = "usuarioController", value = "/usuarioController")
public class UsuarioController extends HttpServlet {
    UsuarioService usuarioService = new UsuarioService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            Integer id = Integer.parseInt(req.getParameter("id"));
            String nome = req.getParameter("nome");
            String senha = req.getParameter("senha");
            String tipo = req.getParameter("tipo");

            Usuario usuario = new Usuario(id, nome, senha, Tipo.usuario);
            usuarioService.Inserir(usuario);

            resp.sendRedirect("/Livraria_war_exploded/usuarioController");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        ArrayList<Usuario> usuarios = usuarioService.buscarUsuarios();

        for (Usuario u :
                usuarios) {
            System.out.println("AQUI É O CONTROLLER");
            System.out.println(u.getId() + u.getNome() + u.getSenha() +u.getTipo());
        }

        //HttpSession request = null;
        req.setAttribute("usuarios", usuarios);


        RequestDispatcher dispatcher = req.getRequestDispatcher("listaUsuarios.jsp");
        //ServletResponse response = null;
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
