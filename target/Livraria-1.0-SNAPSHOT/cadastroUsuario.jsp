<%--
  Created by IntelliJ IDEA.
  User: jonas
  Date: 19/06/2023
  Time: 19:06
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
<form action="usuarioController" method="post">
    <label>ID</label>
    <input id="id" name="id"><br>
    <label>Nome</label>
    <input id="nome" name="nome"><br>
    <label>Senha</label>
    <input id="senha" name="senha"><br>
    <label>Tipo</label>
    <select id="tipo" name="tipo">
        <option>usuario</option>
        <option>administrador</option>
    </select>
    <input type="hidden"><br>

    <input type="submit" value="Salvar Usuario">
</form>

</body>
</html>
