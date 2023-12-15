package projeto.repositorio;

import java.sql.*;
import org.eclipse.jetty.io.RuntimeIOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import projeto.entidade.Pessoa;

public class PessoaRepositorio extends Repositorio {

    public List<Pessoa> findByNome(@Nonnull final String nome) { // copiar e colar esse método em uma classe aleatória
                                                                 // para mostrar o bug de não importar
        try {
            final Connection connection = getConnection();

            final String sql = "SELECT * FROM pessoa WHERE nome ILIKE ?"; // joao sem acento não pega no ilike
            final String like = "%nome%".replace("nome", nome);
            System.out.println(like);

            final PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, like); 
            final ResultSet resultSet = statement.executeQuery();
            final List<Pessoa> pessoas = new ArrayList<>();

            while (resultSet.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(resultSet.getInt("id"));
                pessoa.setNome(resultSet.getString("nome"));
                pessoa.setIdade(resultSet.getInt("idade"));
                pessoas.add(pessoa);
            }
            return pessoas;
        } catch (Exception e) {
            throw new RuntimeIOException(e);
        } 

    }

    public void save(Pessoa pessoa) { 
        try {
            final Connection connection = getConnection();

            final String sql = "INSERT INTO pessoa (nome, idade) VALUES (?, ?)"; // joao sem acento não pega no ilike
            final PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pessoa.getNome());
            statement.setInt(2, pessoa.getIdade());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeIOException(e);
        }

    }

    public void delete(Pessoa pessoa) { 
        try {
            final Connection connection = getConnection();

            final String sql = "DELETE FROM pessoa WHERE nome ILIKE ?"; // joao sem acento não pega no ilike
            final PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pessoa.getNome());
            // statement.setInt(1, pessoa.getId());//apagar pelo id? ou apagar pelo nome? ou utilizar os 2? Minha resposta é, depende da aplicação, porém aqui deixei só o nome
            
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeIOException(e);
        }

    }

    public void update(Pessoa pessoa) {
        try {
            final Connection connection = getConnection();
    
            final String sql = "UPDATE pessoa SET nome = ?, idade = ? WHERE id = ?";
            final PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pessoa.getNome());
            statement.setInt(2, pessoa.getIdade());
            statement.setInt(3, pessoa.getId());
    
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeIOException(e);
        }
    }

}
