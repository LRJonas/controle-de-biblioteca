<%@ page import="com.example.livraria.Model.Usuario" %>
<%@ page import="com.example.livraria.Model.Tipo" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    Boolean logado = (Boolean) session.getAttribute("is_logged_in");
    if(logado == null || false){
        response.sendRedirect("http://localhost:8080/Livraria_war_exploded/index.jsp");
    }

    Usuario usuario = (Usuario) session.getAttribute("usuario");


%>
<!DOCTYPE html>
<html>
<head>
    <title>Pagina Inicial</title>

</head>
<body>


    Livraria do Jonas
    <form method="get" action="livrosController">

        <input type="submit" value="Listar Livros">
    </form>


    <br>
    <%if(usuario.getTipo().equals(Tipo.administrador)){%>

            <a href="cadastroLivro.jsp">Cadastrar Livro</a>
            <br>
            <a href="cadastroUsuario.jsp">Cadastrar Usuário</a><br>
            <br>
            <form method="get" action="usuarioController">

                <input type="submit" value="Listar Usuários">
            </form>
       <% } %>








</body>
</html>