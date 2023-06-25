<%--
  Created by IntelliJ IDEA.
  User: jonas
  Date: 19/06/2023
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import= "com.example.livraria.Model.Usuario" %>
<%

    Usuario usuario = (Usuario) request.getAttribute("usuario");
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
<form action="updateUsuario" method="post">


    <input type="hidden" id="id" name="id" value="<%= usuario.getId() %>"><br>
    <label>Nome</label>
    <input id="nome" name="nome" type="text" value="<%= usuario.getNome() %>"><br>
    <label>Senha</label>
    <input id="senha" name="senha" value="<%= usuario.getSenha() %>"><br>
    <label>Data Criação</label>

    <select id="tipo" name="tipo" >
        <option>administrador</option>
        <option>usuario</option>

    </select>
    <input value="<%= usuario.getTipo() %>"  name="tipo"><br>

    <input type="submit" value="Salvar Usuário">

</form>

</body>
</html>
