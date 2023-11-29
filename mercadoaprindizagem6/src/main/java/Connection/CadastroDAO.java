package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Connection.ConnectionFactory;
import Model.Cadastro;
import Model.Produtos;

/**
 * CadastroDAO
 */
public class CadastroDAO {
    // atributo
    private Connection connection;
    private List<Cadastro> Cadastro;

    // construtor
    public CadastroDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // criar Tabela
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS Cadastro_mercado (NOME VARCHAR(255),MARCA VARCHAR(255),QUANTIDADE VARCHAR(255),CODIGO VARCHAR(255) PRIMARY KEY, PRECO VARCHAR(255))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Listar todos os clientes cadastrados
    public List<Model.Cadastro> listarTodos() {
        PreparedStatement stmt = null;
        // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
        // Declaração do objeto ResultSet para armazenar os resultados da consulta
        Cadastro = new ArrayList<>();
        // Cria uma lista para armazenar os Cadastro recuperados do banco de dados
        try {
            stmt = connection.prepareStatement("SELECT * FROM Cadastro_mercado");
            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto Cadastro com os clientes do
                // registro

                Cadastro carro = new Cadastro(
                        rs.getString("nome"),
                        rs.getString("marca"),
                        rs.getString("quantidade"),
                        rs.getString("codigo"),
                        rs.getString("preco"));
                Cadastro.add(carro); // Adiciona o objeto Cadastro à lista de Cadastro
            }
        } catch (SQLException ex) {
            System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);

            // Fecha a conexão, o PreparedStatement e o ResultSet
        }
        return Cadastro; // Retorna a lista de Cadastro recuperados do banco de dados
    }

    // Cadastrar Carro no banco
    public void cadastrar(String nome, String marca, String quantidade, String codigo, String preco) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para cadastrar na tabela
        String sql = "INSERT INTO Cadastro_mercado (nome, marca, quantidade, codigo, preco) VALUES (?, ?, ?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, marca);
            stmt.setString(3, quantidade);
            stmt.setString(4, codigo);
            stmt.setString(5, preco);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Atualizar dados no banco
    public void atualizar(String nome, String marca, String quantidade, String codigo, String preco) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para atualizar dados pela codigo
        String sql = "UPDATE Cadastro_mercado SET nome = ?, marca = ?, quantidade = ?, preco = ? WHERE codigo = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, marca);
            stmt.setString(3, quantidade);
            stmt.setString(4, preco);
            // codigo é chave primaria não pode ser alterada.
            stmt.setString(5, codigo);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Apagar dados do banco
    public void apagar(String codigo) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para apagar dados pela codigo
        String sql = "DELETE FROM Cadastro_mercado WHERE codigo = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, codigo);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
}
