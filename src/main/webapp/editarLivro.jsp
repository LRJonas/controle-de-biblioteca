<%--
  Created by IntelliJ IDEA.
  User: jonas
  Date: 18/06/2023
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page import= "com.example.livraria.Model.Livros" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //ArrayList<Livros> livros = (ArrayList<Livros>) request.getAttribute("livros");
    Livros livro = (Livros) request.getAttribute("livro");
    Boolean logado = (Boolean) session.getAttribute("is_logged_in");
    if(logado == null || false){
        response.sendRedirect("http://localhost:8080/Livraria_war_exploded/index.jsp");
    }


%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="updateLivro" method="post">


        <input id="id" name="id"  type = "hidden" value="<%= livro.getId() %>"><br>
        <label>Nome do Livro</label>
        <input id="nome" name="nome" type="text" value="<%= livro.getNome() %>"><br>
        <label>Autor</label>
        <input id="autor" name="autor" value="<%= livro.getAutor() %>"><br>
        <label>Data Criação</label>
        <input id="data_criacao" name="data_criacao" value="<%= livro.getData_criacao() %>"> <br>
        <label>Status</label>
        <select id="status_livro" name="status_livro" >
          <option>disponível</option>
          <option>indisponível</option>
          <option>emprestado</option>
        </select>
        <label>Satus Atual</label>
        <input value="<%= livro.getStatus_livro() %>" id="status_livro" name="status_livro"><br>

        <input type="submit" value="Salvar Livro">

    </form>


    </body>
</html>
