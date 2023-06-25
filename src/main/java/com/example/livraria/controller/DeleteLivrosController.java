package com.example.livraria.controller;

import com.example.livraria.repository.LivrosRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
@WebServlet(name = "deletarLivro", value = "/deletarLivro")
public class DeleteLivrosController extends HttpServlet {

    LivrosRepository livrosRepository = new LivrosRepository();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("idDel"));
        try {
            livrosRepository.Delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
