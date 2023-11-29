package Controller;
import java.util.List;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Connection.CadastroDAO;
import Model.Cadastro;

/**
 * CadastroControl
 */
public class CadastroControl {
    // Atributos
    private List<Cadastro> Cadastro;
    private DefaultTableModel tableModel;
    private JTable table;

    // Construtor
    public CadastroControl(List<Cadastro> Cadastro, DefaultTableModel tableModel, JTable table) {
        this.Cadastro = Cadastro;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        Cadastro = new CadastroDAO().listarTodos();
        // Obtém os Cadastro atualizados do banco de dados
        for (Cadastro carro : Cadastro) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { carro.getNome(), carro.getSobrenome(), carro.getCpf(), carro.getendereco(),
                    carro.getidade() });
        }
    }

    // Método para cadastrar um novo carro no banco de dados
    public void cadastrar(String nome, String marca, String quantidade, String codigo, String preco) {
        new CadastroDAO().cadastrar(nome, marca, quantidade, codigo, preco);
        // Chama o método de cadastro no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
    }

    // Método para atualizar os dados de um carro no banco de dados
    public void atualizar(String nome, String marca, String quantidade, String codigo, String preco) {
        new CadastroDAO().atualizar(nome, marca, quantidade, codigo, preco);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    // Método para apagar um carro do banco de dados
    public void apagar(String codigo) {
        new CadastroDAO().apagar(codigo);
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
    }
}
