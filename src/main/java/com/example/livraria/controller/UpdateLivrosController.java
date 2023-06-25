package com.example.livraria.controller;

import com.example.livraria.Model.Livros;
import com.example.livraria.service.LivrosService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "updateLivro", value = "/updateLivro")
public class UpdateLivrosController extends HttpServlet {
    LivrosService livrosService = new LivrosService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        //HttpSession request = null;

        Livros livro = null;



        Integer id = Integer.parseInt(req.getParameter("id"));
        String nome = req.getParameter("nome");
        String autor = req.getParameter("autor");
        String data = req.getParameter("data_criacao");
        String status = req.getParameter("status_livro");

        //Livros livro = new Livros(id,nome, autor, data, status );

        try {
            livro = livrosService.buscarUm(id);
            req.setAttribute("livro", livro);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("editarLivro.jsp");
        //ServletResponse response = null;
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));
        String nome = req.getParameter("nome");
        String autor = req.getParameter("autor");
        String data = req.getParameter("data_criacao");
        String status = req.getParameter("status_livro");

        Livros livro = new Livros(id,nome, autor, data, status );

        try {
            livrosService.Update(livro);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
