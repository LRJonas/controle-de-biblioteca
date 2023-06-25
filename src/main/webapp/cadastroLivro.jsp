<%--
  Created by IntelliJ IDEA.
  User: jonas
  Date: 18/06/2023
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
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
<form action="livrosController" method="post">
  <label>ID</label>
  <input id="id" name="id"><br>
  <label>Nome do Livro</label>
  <input id="nome" name="nome"><br>
  <label>Autor</label>
  <input id="autor" name="autor"><br>
  <label>Data Criação</label>
  <input id="data_criacao" name="data_criacao"><br>
  <label>Status</label>
  <select id="status_livro" name="status_livro">
    <option>disponível</option>
    <option>indisponível</option>
    <option>emprestado</option>
  </select>
  <input type="hidden"><br>

  <input type="submit" value="Salvar Livro">
</form>

</body>
</html>
