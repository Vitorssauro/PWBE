package View;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VendasView extends JPanel {
    private JButton procurar, adicionar, cadVenda;
    private JTextField cadCpfField,totalField,totalDescField;
    private DefaultTableModel tableModel;
    private JTable table;
    private JComboBox<String> codBarrasBox;

    public VendasView() {
        super();

        //add(new JLabel("Venda de Produto"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2,2));

        cadCpfField = new JTextField("Digite o CPF", 22);
        inputPanel.add(cadCpfField);

        inputPanel.add(procurar = new JButton("Procurar"));

        // componentes Jcombobox
        codBarrasBox = new JComboBox<>();
        codBarrasBox.addItem("Cod. de Barras");
        codBarrasBox.addItem("1");
        codBarrasBox.addItem("2");
        inputPanel.add(codBarrasBox);

        inputPanel.add(adicionar = new JButton("Adicionar"));

        add(inputPanel);

        // tabela de compras
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Item", "Qtd.", "$Un", "Preço Total" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        JPanel submitPanel = new JPanel();
        totalField = new JTextField("Valor total", 17);
        submitPanel.add(totalField);
        totalDescField = new JTextField("Total Desc.", 17);
        submitPanel.add(totalDescField);

        submitPanel.add(cadVenda = new JButton("Cad. Venda"));

        add(submitPanel);
    }

}
