package com.example.livraria.controller;

import com.example.livraria.Model.Livros;
import com.example.livraria.repository.LivrosRepository;
import com.example.livraria.service.LivrosService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "livrosController", value={"/livrosController"})
public class LivrosController extends HttpServlet {
    LivrosService livrosService = new LivrosService();
    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //LivrosRepository livrosRepository = new LivrosRepository();

        ArrayList<Livros> livros = (ArrayList<Livros>) livrosService.buscarLivros();

        for (Livros l :
                livros) {
            System.out.println("AQUI É O CONTROLLER");
            System.out.println(l.getId() + l.getNome());
        }

        //HttpSession request = null;
        req.setAttribute("livros", livros);
        
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("listaLivros.jsp");
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
            livrosService.Inserir(livro);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}