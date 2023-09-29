import javax.swing.*;
import java.awt.*;

public class AtividadeJogoCardLayoutCrr extends JFrame {
    // atributo
    int pontuacao = 0;

    // costrutor
    public AtividadeJogoCardLayoutCrr() {
        super("Exercicio 5 - Quiz");
        // criar um painel principal - CardLayout
        CardLayout cl = new CardLayout();
        JPanel mainPanel = new JPanel(cl);
        this.add(mainPanel); // add painel ao frame
        // criação dos Cards
        // card1 - Tela de Start
        JPanel card1 = new JPanel();
        card1.add(new JLabel("Seja Bem Vindo ao Quiz"));
        JButton but1 = new JButton("Start");
        card1.add(but1);// criei o botão e coloquei a ação

        mainPanel.add(card1);// add card ao painel principal
        // card2 - Primeira Pergunta
        JPanel card2 = new JPanel();
        card2.add(new JLabel("Pergunta 1 - Quem venceu a copa de 70?"));
        JTextField resposta1 = new JTextField(20);
        card2.add(resposta1);
        JButton but2 = new JButton("Next");
        card2.add(but2);// criei o botão e coloquei a ação
        mainPanel.add(card2);// add card ao painel principal
        // card3 - Primeira Pergunta
        JPanel card3 = new JPanel();
        card3.add(new JLabel("Pergunta 2 - Onde Foi a Copa de 70"));
        JTextField resposta2 = new JTextField(20);
        card3.add(resposta2);
        JButton but3 = new JButton("Next");
        card3.add(but3);// criei o botão e coloquei a ação

        mainPanel.add(card3);// add card ao painel principal
        // card4 - Tela de Start
        JPanel card4 = new JPanel();
        card4.add(new JLabel("Obrigado por Jogar"));
        JLabel pontucaoFinal = new JLabel("");
        card4.add(pontucaoFinal);
        JButton but4 = new JButton("Jogar Novamente");
        card4.add(but4);// criei o botão e coloquei a ação
        mainPanel.add(card4);// add card ao painel principal
        // set do Frame
        this.setDefaultCloseOperation(2);// definindo a função do X do Frame
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);

        /// ações do botão
        but1.addActionListener(e -> {
            cl.next(mainPanel);
        });
        but2.addActionListener(e -> {
            // verificar a resposta
            if (resposta1.getText().toLowerCase().equals("brasil")) {
                pontuacao++;
            }
            cl.next(mainPanel);
            resposta1.setText("");
        });
        but3.addActionListener(e -> {
            // verificar a resposta
            if (resposta2.getText().toLowerCase().equals("méxico")) {
                pontuacao++;
            }
            cl.next(mainPanel);
            resposta2.setText("");
            pontucaoFinal.setText("Sua pontuação Foi de " + pontuacao);

        });
        but4.addActionListener(e -> {
            cl.first(mainPanel);
            pontuacao = 0;
        });

    }
}