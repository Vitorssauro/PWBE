package Controller;

import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Connection.ProdutosDAO;
import Model.Produtos;

/**
 * ProdutosControl
 */
public class ProdutosControl {
    // Atributos
    private List<Produtos> produtos;
    private DefaultTableModel tableModel;
    private JTable table;

    // Construtor
    public ProdutosControl(List<Produtos> produtos, DefaultTableModel tableModel, JTable table) {
        this.produtos = produtos;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        produtos = new ProdutosDAO().listarTodos();
        // Obtém os produtos atualizados do banco de dados
        for (Produtos produto : produtos) {
            // Adiciona os dados de cada produto como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { produto.getNome(), produto.getMarca(),

                    produto.getQuantidade(), produto.getCodigo(), produto.getPreco() });
        }
    }

    // Método para cadastrar um novo produto no banco de dados
    public void cadastrar(String nome, String marca, String quantidade, String codigo, String preco) {
        new ProdutosDAO().cadastrar(nome, marca, quantidade, codigo, preco);
        // Chama o método de cadastro no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
        JOptionPane.showMessageDialog(null,"Cadastro Realizado com Sucesso");
    }

    // Método para atualizar os dados de um produto no banco de dados
    public void atualizar(String nome, String marca, String quantidade, String codigo, String preco) {
        new ProdutosDAO().atualizar(nome, marca, quantidade, codigo, preco);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
        
    }

    // Método para apagar um produto do banco de dados
    public void apagar(String codigo) {
        int opcao = JOptionPane.showConfirmDialog(null, "Realmente deseja apagar?", "Confirmação", JOptionPane.YES_NO_OPTION);
        
        if (opcao == JOptionPane.YES_OPTION) {
            // Se o usuário pressionou 'Sim', então apaga
            new ProdutosDAO().apagar(codigo);
            atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
        } else {
            // Se o usuário pressionou 'Não' ou fechou a caixa de diálogo, não faz nada
        }
    }
}
