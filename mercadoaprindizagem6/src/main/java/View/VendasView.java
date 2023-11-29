package View;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Connection.CadastroDAO;
import Connection.ProdutosDAO;
import Model.Cadastro;
import Model.Produtos;

public class VendasView extends JPanel {
    JComboBox<String> produtosComboBox;
    private JComboBox codBarrasBox;
    private JButton procurar, adicionar, cadVenda;
    private JTextField cadCpfField;

    public VendasView() {
        super();
        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Nome"));
        cadCpfField = new JTextField(20);
        add(inputPanel);
    }



}
