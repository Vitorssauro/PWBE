import javax.swing.*;
import java.awt.*;

public class ExemploCalculadoraGUI {
    public ExemploCalculadoraGUI() {

        // construir Layout
        BorderLayout border = new BorderLayout();
        JFrame janelaP = new JFrame("Layout Calculadora");
        janelaP.setLayout(border);
        JPanel painelV = new JPanel();
        JPanel painelB = new JPanel(); // Padrão FlowLayout
        janelaP.getContentPane().add(painelB, BorderLayout.CENTER);        
        janelaP.getContentPane().add(painelV);
        //adicionar o textFild no PainelV
        JTextField caixa1 = new JTextField(25);
        painelV.add(caixa1);
        // set Layout do JPane
        GridLayout grid = new GridLayout(4, 4);
        painelB.setLayout(grid);
        /// Vetor com os textos dos botões
        String textBotoes[] = { "C", "9", "8", "7", "/", "6", "5", "4", "*", "3", "2", "1", "-", ".", "0", "=" };
        for (int i = 0; i < textBotoes.length; i++) {
            painelB.add(new JButton(textBotoes[i]));
        }
        //set do frame
        janelaP.setBounds(500, 500, 500, 500);
        janelaP.setDefaultCloseOperation(2);
        janelaP.setVisible(true);
    }

}
