package com.example.livraria.repository;

import com.example.livraria.Model.Livros;
import com.example.livraria.Model.Tipo;
import com.example.livraria.Model.Usuario;
import com.example.livraria.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioRepository {

    private Connection conn;
    Statement st = null;
    ResultSet rs = null;

    public UsuarioRepository(){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        conn = ConnectionFactory.getConnection();
    }

    public ArrayList<Usuario> buscarUsuarios(){

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try{
            st= conn.createStatement();
            rs= st.executeQuery("SELECT * FROM Usuario");
            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                String tipo = rs.getString("tipo");

                Usuario usuario = new Usuario(id, nome, senha, Tipo.valueOf(tipo));

                System.out.println("AQUI É O REPOSITORY");
                System.out.println(rs.getInt("id") + rs.getString("nome") + rs.getString("senha") + rs.getString("tipo"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {

                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {

                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return usuarios;
    }

    public boolean Inserir(Usuario usuario) throws SQLException {
        st= conn.createStatement();
        st.executeUpdate("INSERT INTO Usuario VALUES (" + usuario.getId() + ", '" + usuario.getNome() + "', '" + usuario.getSenha() + "', '" + usuario.getTipo() + "');");


        return true;
    }
    public boolean Update(Usuario usuario) throws SQLException {
        st= conn.createStatement();
        st.executeUpdate("UPDATE Usuario SET " + "nome = '" + usuario.getNome() + "', senha= '" + usuario.getSenha() +  "', tipo= '" + usuario.getTipo() + "' WHERE id = " + usuario.getId() +";");


        return true;
    }
    public Usuario buscarUm(Integer id) throws SQLException {

        st = conn.createStatement();
        rs = st.executeQuery("SELECT * FROM Usuario WHERE id =" + id);

        Usuario usuario = null;
        while (rs.next()) {
            //int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String senha = rs.getString("senha");
            String tipo = rs.getString("tipo");

            usuario = new Usuario(id, nome, senha, Tipo.valueOf(tipo));


            System.out.println("AQUI É O RESULTADO DO BUSCA UM");
            System.out.println(rs.getInt("id") + rs.getString("nome") + rs.getString("senha"));
        }
        return usuario;
    }
    public boolean Delete(Integer id) throws SQLException {
        st= conn.createStatement();
        st.executeUpdate("DELETE FROM Usuario WHERE id =" + id + " ;");


        return true;
    }

    public Usuario BuscaLogin (String nome1, String senha1 ) throws SQLException {

        st = conn.createStatement();
        rs = st.executeQuery("SELECT * FROM Usuario");

        Usuario usuario= null;



        while (rs.next()) {


            Integer id = rs.getInt("id");
            String nome = rs.getString("nome");
            String senha = rs.getString("senha");
            String tipo = rs.getString("tipo");

            if(nome1.equals(nome) && senha1.equals(senha)){
                usuario = new Usuario(id, nome, senha, Tipo.valueOf(tipo));
            }




            //System.out.println(rs.getInt("id") + rs.getString("nome") + rs.getString("senha") + rs.getString("tipo"));

        }
        System.out.println("AQUI É O REPOSITORY DA BUSCA LOGIN");
        System.out.println(usuario.getNome() + usuario.getSenha());
        return usuario;
    }
}
