<%--
  Created by IntelliJ IDEA.
  User: jonas
  Date: 17/06/2023
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import= "com.example.livraria.Model.Livros" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.livraria.controller.LivrosController" %>

<%
    ArrayList<Livros> livros = (ArrayList<Livros>) request.getAttribute("livros");
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
<table>
    <tr>
        <td>#Id</td>
        <td>Nome</td>
        <td>Autor</td>
        <td>Data</td>
        <td>Status</td>
        <td>Editar</td>
        <td>Deletar</td>
    </tr>
    <%for (Livros l: livros ) { %>
        <tr>
            <td><%=l.getId()%></td>
            <td><%=l.getNome()%></td>
            <td><%=l.getAutor()%></td>
            <td><%=l.getData_criacao()%></td>
            <td><%=l.getStatus_livro()%></td>

            <td>
                <form method="get" action="updateLivro">

                    <input type="submit" value="<%=l.getId()%>" id="id" name="id" placeholder="Editar">
                </form>
            </td>
            <td>
                <form method="post" action="deletarLivro">
                    <input type="submit" value="<%=l.getId()%>" id="idDel" name="idDel" >
                </form>
            </td>

        </tr>

    <%    } %>
</table>
</body>
</html>
