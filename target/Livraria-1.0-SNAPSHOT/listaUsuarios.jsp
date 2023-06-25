<%@ page import="com.example.livraria.Model.Usuario" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: jonas
  Date: 19/06/2023
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
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
        <td>Tipo</td>
        <td>Editar</td>
        <td>Deletar</td>
    </tr>
    <%for (Usuario l: usuarios ) { %>
    <tr>
        <td><%=l.getId()%></td>
        <td><%=l.getNome()%></td>
        <td><%=l.getTipo()%></td>


        <td>
            <form method="get" action="updateUsuario">

                <input type="submit" value="<%=l.getId()%>" id="id" name="id" placeholder="Editar">
            </form>
        </td>
        <td>
            <form method="post" action="deletarUsuario">
                <input type="submit" value="<%=l.getId()%>" id="idDel" name="idDel" >
            </form>
        </td>

    </tr>

    <%    } %>
</table>

</body>
</html>
