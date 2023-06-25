package com.example.livraria.repository;

import com.example.livraria.Model.Livros;
import com.example.livraria.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LivrosRepository {

    private Connection conn;
    Statement st = null;
    ResultSet rs = null;

    public LivrosRepository(){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        conn = ConnectionFactory.getConnection();
    }



    public ArrayList<Livros> getLivros(){


        ArrayList<Livros> livros = new ArrayList<Livros>();

        try{
            st= conn.createStatement();
            rs= st.executeQuery("SELECT * FROM Livros");
            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String autor = rs.getString("autor");
                String data = rs.getString("data_criacao");
                String status = rs.getString("status_livro");

                Livros livro = new Livros(id,nome, autor, data, status);
                System.out.println(rs.getInt("id") + rs.getString("nome") + rs.getString("autor"));
                livros.add(livro);
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

        return livros;
    }

    public boolean Inserir(Livros livro) throws SQLException {
        st= conn.createStatement();
        st.executeUpdate("INSERT INTO Livros VALUES (" + livro.getId() + ", '" + livro.getNome() + "', '" + livro.getAutor() + "', '" + livro.getData_criacao() + "', '" + livro.getStatus_livro() + "');");


        return true;
    }

    public boolean Update(Livros livro) throws SQLException {
        st= conn.createStatement();
        st.executeUpdate("UPDATE Livros SET " + "nome = '" + livro.getNome() + "', autor= '" + livro.getAutor() + "', data_criacao = '" + livro.getData_criacao() + "', status_livro= '" + livro.getStatus_livro() + "' WHERE id = " + livro.getId() +";");


        return true;
    }

    public Livros buscarUm(Integer id) throws SQLException {

        st = conn.createStatement();
        rs = st.executeQuery("SELECT * FROM Livros WHERE id =" + id);
        Livros livro = null;
        while (rs.next()) {
            //int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String autor = rs.getString("autor");
            String data = rs.getString("data_criacao");
            String status = rs.getString("status_livro");

            livro = new Livros(id, nome, autor, data, status);
            System.out.println("AQUI É O RESULTADO DO BUSCA UM");
            System.out.println(rs.getInt("id") + rs.getString("nome") + rs.getString("autor"));
        }
        return livro;
    }
    public boolean Delete(Integer id) throws SQLException {
        st= conn.createStatement();
        st.executeUpdate("DELETE FROM Livros WHERE id =" + id + " ;");


        return true;
    }
}
