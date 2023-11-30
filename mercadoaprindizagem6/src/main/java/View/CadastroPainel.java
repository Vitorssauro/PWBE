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

import Connection.CadastroDAO;
import Controller.CadastroControl;
import Model.Cadastro;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroPainel extends JPanel {
    // Atributos(componentes)
    private JButton cadastrar, apagar, editar;
    private JTextField cadNomeField, cadSobrenomeField, cadCpfField, cadEnderecoField,
            cadIdadeField;
    private List<Cadastro> Cadastro;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    // Construtor(GUI-JPanel)
    public CadastroPainel() {
        super();
        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro Clientes"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Nome"));
        cadNomeField = new JTextField(20);
        inputPanel.add(cadNomeField);
        inputPanel.add(new JLabel("Sobrenome"));
        cadSobrenomeField = new JTextField(20);
        inputPanel.add(cadSobrenomeField);
        inputPanel.add(new JLabel("Cpf"));
        cadCpfField = new JTextField(20);
        inputPanel.add(cadCpfField);
        inputPanel.add(new JLabel("Endereco"));
        cadEnderecoField = new JTextField(20);
        inputPanel.add(cadEnderecoField);
        inputPanel.add(new JLabel("Idade"));
        cadIdadeField = new JTextField(20);
        inputPanel.add(cadIdadeField);
        add(inputPanel);
        JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar"));
        botoes.add(editar = new JButton("Editar"));
        botoes.add(apagar = new JButton("Apagar"));
        add(botoes);
        // tabela de Cadastro
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Nome", "Sobrenome", "Cpf", "Endereco", "Idade" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);
        // criar o banco de dados
        new CadastroDAO().criaTabela();
        // executar o método de atualizar tabela
        atualizarTabela();
        // tratamento de eventos
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    //se o valor da primeira linha for texto seta dentro do BD
                    cadNomeField.setText((String) table.getValueAt(linhaSelecionada, 0));           
                    cadSobrenomeField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    cadCpfField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    cadEnderecoField.setText((String) table.getValueAt(linhaSelecionada, 3));
                    cadIdadeField.setText((String) table.getValueAt(linhaSelecionada, 4));
                }
            }
        });

        CadastroControl operacoes = new CadastroControl(Cadastro, tableModel, table);

        // tratamento para o botao cadastrar 
        cadastrar.addActionListener(e -> {
            operacoes.cadastrar(cadNomeField.getText(), cadSobrenomeField.getText(), cadCpfField.getText(),
                    cadEnderecoField.getText(), cadIdadeField.getText());
            cadNomeField.setText("");
            cadSobrenomeField.setText("");
            cadCpfField.setText("");
            cadEnderecoField.setText("");
            cadIdadeField.setText("");
        });

        // tratamento do botão editar
        editar.addActionListener(e -> {
            operacoes.atualizar(cadNomeField.getText(), cadSobrenomeField.getText(), cadCpfField.getText(),
                    cadEnderecoField.getText(), cadIdadeField.getText());
            cadNomeField.setText("");
            cadSobrenomeField.setText("");
            cadCpfField.setText("");
            cadEnderecoField.setText("");
            cadIdadeField.setText("");
        });

        // tratamento do botão apagar
        apagar.addActionListener(e -> {
            operacoes.apagar(cadEnderecoField.getText());
            cadNomeField.setText("");
            cadSobrenomeField.setText("");
            cadCpfField.setText("");
            cadEnderecoField.setText("");
            cadIdadeField.setText("");
        });

    }

    // métodos(Atualizar tabela)
    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        Cadastro = new CadastroDAO().listarTodos();
        // Obtém os Cadastro atualizados do banco de dados
        for (Cadastro cadastro : Cadastro) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { cadastro.getNome(), cadastro.getSobrenome(),
                    cadastro.getCpf(), cadastro.getendereco(), cadastro.getidade() });
        }
    }
}
