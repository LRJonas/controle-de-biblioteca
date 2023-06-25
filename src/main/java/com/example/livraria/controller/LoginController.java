package com.example.livraria.controller;

import com.example.livraria.service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(name = "login", value = "/login")
public class LoginController extends HttpServlet {

    LoginService loginService = new LoginService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");

        System.out.println(nome + senha);

        try{
            loginService.validaRLogin(nome, senha, req);

            resp.sendRedirect("http://localhost:8080/Livraria_war_exploded/landing.jsp");
        } catch (Exception e) {

            String mensagem = e.getMessage();
            resp.sendRedirect("http://localhost:8080/Livraria_war_exploded/index.jsp?msg=" + mensagem);
            System.out.println(mensagem);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        session.invalidate();

        resp.sendRedirect("http://localhost:8080/login/index.jsp");
    }
}
