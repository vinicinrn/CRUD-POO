package Aplicar;

import Model.Pessoa;
import ConnectionFactory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    public void salvarPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO pessoas (nome, endereco, telefone) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, pessoa.getNome());
            pstm.setString(2, pessoa.getEndereco());
            pstm.setString(3, pessoa.getTelefone());
            pstm.executeUpdate(); // Use executeUpdate() for INSERT, UPDATE, DELETE queries
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pessoa> listarPessoas() {
        String sql = "SELECT * FROM pessoas";
        List<Pessoa> pessoas = new ArrayList<>();

        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rset = pstm.executeQuery()) {

            while (rset.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rset.getInt("id"));
                pessoa.setNome(rset.getString("nome"));
                pessoa.setEndereco(rset.getString("endereco"));
                pessoa.setTelefone(rset.getString("telefone"));
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pessoas;
    }

    public void atualizarPessoa(Pessoa pessoa) {
        String sql = "UPDATE pessoas SET nome = ?, endereco = ?, telefone = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, pessoa.getNome());
            pstm.setString(2, pessoa.getEndereco());
            pstm.setString(3, pessoa.getTelefone());
            pstm.setInt(4, pessoa.getId());
            pstm.executeUpdate(); // Use executeUpdate() for INSERT, UPDATE, DELETE queries
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarPessoa(int id) {
        String sql = "DELETE FROM pessoas WHERE id = ?";

        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, id);
            pstm.executeUpdate(); // Use executeUpdate() for INSERT, UPDATE, DELETE queries
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
