
package org.tidesigners.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.tidesigners.jdbc.FabricaDeConexoes;
import org.tidesigners.logica.Contato;

public class ContatoDAO {

    private final Connection con;

    public ContatoDAO() {
        this.con = FabricaDeConexoes.conectar();
    }

    public void adiciona(Contato c1) throws SQLException {

        String sql = "insert into contatos (nome, endereco, email, fone, sexo)"
                + "values(?,?,?,?,?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, c1.getNome());
            stmt.setString(2, c1.getEndereco());
            stmt.setString(3, c1.getEmail());
            stmt.setString(4, c1.getFone());
            stmt.setString(5, c1.getSexo());

            stmt.execute();
            stmt.close();
        }

    }

    public List<Contato> getLista(String nome) throws SQLException {
        String sql = "select * from contatos where nome like ?";
        List<Contato> minhaLista;
        try (PreparedStatement stmt = this.con.prepareStatement(sql)) {
            stmt.setString(1, nome);
            try (ResultSet rs = stmt.executeQuery()) {
                minhaLista = new ArrayList<>();
                while (rs.next()) {

                    Contato c1 = new Contato();
                    c1.setId(Long.valueOf(rs.getString("Id")));
                    c1.setNome(rs.getString("nome"));
                    c1.setEndereco(rs.getString("endereco"));
                    c1.setEmail(rs.getString("email"));
                    c1.setFone(rs.getString("fone"));
                    c1.setSexo(rs.getString("sexo"));
                    minhaLista.add(c1);

                }
            }
        }

        return minhaLista;
    }

    public void altera(Contato c1) throws SQLException {

        String sql = "update contatos set nome=?, endereco=?, email=?, fone=?, sexo=? where id=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, c1.getNome());
            stmt.setString(2, c1.getEndereco());
            stmt.setString(3, c1.getEmail());
            stmt.setString(4, c1.getFone());
            stmt.setString(5, c1.getSexo());
            stmt.setLong(6, c1.getId());

            stmt.execute();
        }

    }

    public void remove(Contato c1) throws SQLException {

        String sql = "delete from contatos where id=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, c1.getId());

            stmt.execute();
        }

    }

}
