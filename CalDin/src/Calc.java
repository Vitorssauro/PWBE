import javax.swing.*;
import java.awt.*;

public class Calc {

    public Calc() {
        // Criando JFrame
        JFrame janelaP = new JFrame("Conversor de Moeda");
        janelaP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaP.setSize(300, 150);

        // Chamei o LAyout
        GridLayout grid = new GridLayout();
        janelaP.setLayout(grid);// atribui o layout

        // Criar a label temperatura
        JLabel texto = new JLabel("Moeda : ");
        janelaP.add(texto);

        // criar alguns componentes 1
        String[] temp1 = { "Real", "Dolar", "Euro", "Libra" };
        JComboBox<String> comboBox = new JComboBox<>(temp1);
        janelaP.add(comboBox);

        // Criar a label ceonverter
        JLabel texto1 = new JLabel("Converter para : ");
        janelaP.add(texto1);

        // criar alguns componentes 2
        String[] temp2 = { "Dolar", "Real", "Euro", "Libra" };
        JComboBox<String> comboBox1 = new JComboBox<>(temp2);
        janelaP.add(comboBox1);

        // texto para digitar as temperaturasValor
        JLabel barra = new JLabel(" // ");
        JTextField tempTexto1 = new JTextField(" Valor ", 10);    
        JTextField tempTexto2 = new JTextField(" Valor ", 10);
        janelaP.add(tempTexto1);
        janelaP.add(barra);        
        janelaP.add(tempTexto2);




        // Cria um botão JButton
        JButton button = new JButton("Selecionar");
        janelaP.add(button);

        // Configura a janela para ser visível
        janelaP.setVisible(true);
    }
}
