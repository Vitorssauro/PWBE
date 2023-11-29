package View;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Connection.ProdutosDAO;
import Controller.ProdutosControl;
import Model.Produtos;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProdutosPainel extends JPanel {
    // Atributos(componentes)
    private JButton cadastrar, apagar, editar;
    private JTextField prodNomeField, prodMarcaField, prodQuantidadeField, prodCodigoField,
            prodPrecoField;
    private List<Produtos> produtos;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    // Construtor(GUI-JPanel)
    public ProdutosPainel() {
        super();
        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastros Produtos"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Nome"));
        prodNomeField = new JTextField(20);
        inputPanel.add(prodNomeField);
        inputPanel.add(new JLabel("Marca"));
        prodMarcaField = new JTextField(20);
        inputPanel.add(prodMarcaField);
        inputPanel.add(new JLabel("Quantidade"));
        prodQuantidadeField = new JTextField(20);
        inputPanel.add(prodQuantidadeField);
        inputPanel.add(new JLabel("Codigo"));
        prodCodigoField = new JTextField(20);
        inputPanel.add(prodCodigoField);
        inputPanel.add(new JLabel("Preço"));
        prodPrecoField = new JTextField(20);
        inputPanel.add(prodPrecoField);
        add(inputPanel);
        JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar"));
        botoes.add(editar = new JButton("Editar"));
        botoes.add(apagar = new JButton("Apagar"));
        add(botoes);
        // tabela de produtos
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Nome", "Marca", "Quantidade", "Codigo", "Preco" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);
        // criar o banco de dados
        new ProdutosDAO().criaTabela();
        // executar o método de atualizar tabela
        atualizarTabela();
        // tratamento de eventos
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    prodNomeField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    prodMarcaField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    prodQuantidadeField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    prodCodigoField.setText((String) table.getValueAt(linhaSelecionada, 3));
                    prodPrecoField.setText((String) table.getValueAt(linhaSelecionada, 4));
                }
            }
        });

        ProdutosControl operacoes = new ProdutosControl(produtos, tableModel, table);

        // tratamento para o botçao cadastrar
        cadastrar.addActionListener(e -> {
            operacoes.cadastrar(prodNomeField.getText(), prodMarcaField.getText(), prodQuantidadeField.getText(),
                    prodCodigoField.getText(), prodPrecoField.getText());
            prodNomeField.setText("");
            prodMarcaField.setText("");
            prodQuantidadeField.setText("");
            prodCodigoField.setText("");
            prodPrecoField.setText("");
        });

        // tratamento do botão editar
        editar.addActionListener(e -> {
            operacoes.atualizar(prodNomeField.getText(), prodMarcaField.getText(), prodQuantidadeField.getText(),
                    prodCodigoField.getText(), prodPrecoField.getText());
            prodNomeField.setText("");
            prodMarcaField.setText("");
            prodQuantidadeField.setText("");
            prodCodigoField.setText("");
            prodPrecoField.setText("");
        });

        // tratamento do botão apagar
        apagar.addActionListener(e -> {
            operacoes.apagar(prodCodigoField.getText());
            prodNomeField.setText("");
            prodMarcaField.setText("");
            prodQuantidadeField.setText("");
            prodCodigoField.setText("");
            prodPrecoField.setText("");
        });

    }

    // métodos(Atualizar tabela)
    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        produtos = new ProdutosDAO().listarTodos();
        // Obtém os prodros atualizados do banco de dados
        for (Produtos produto : produtos) {
            // Adiciona os dados de cada produto como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { produto.getNome(), produto.getMarca(),

                    produto.getQuantidade(), produto.getCodigo(), produto.getPreco() });
        }
    }
}
