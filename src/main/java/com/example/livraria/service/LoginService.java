package com.example.livraria.service;

import com.example.livraria.Model.Usuario;
import com.example.livraria.repository.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginService {


    UsuarioRepository usuarioRepository = new UsuarioRepository();

    public void validaRLogin(String nome, String senha, HttpServletRequest request) throws Exception {




        if (nome.isEmpty() || nome == null || senha.isEmpty() || senha == null) {
            throw new Exception("Digite os dados!");

        } else {
            Usuario temUsuario = usuarioRepository.BuscaLogin(nome, senha);

            if (temUsuario.getNome().equals(nome) && temUsuario.getSenha().equals(senha)) {
                HttpSession session = request.getSession();
                session.setAttribute("is_logged_in", true);
                session.setAttribute("usuario", temUsuario);


            } else {
                throw new Exception("Usuário não Cadastrado!");
            }
        }
    }
}
