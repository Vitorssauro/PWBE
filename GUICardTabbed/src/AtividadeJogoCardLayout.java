import javax.swing.*;
import java.awt.*;


public class AtividadeJogoCardLayout extends JFrame{
    public AtividadeJogoCardLayout() {
        super("Quiz");
        
        //criar um Painel Principal -> CardLayout
        JPanel mainPanel = new JPanel();
        CardLayout cl = new CardLayout();
        mainPanel.setLayout(cl);

        //add painel principal ao frame
        this.add(mainPanel);
        //criar os cards da aplicação

        //card1- tela Início
        JPanel card1 = new JPanel();
        card1.add(new JLabel("Seja Bem Vindo ao Quiz"));
        JButton but1 = new JButton("Start");
        card1.add(but1);
        
        mainPanel.add(card1,"Inicio");

        //card2 primeira pergunta TEXTO
        JPanel card2 = new JPanel();
        card2.add(new JLabel("voce gosta de carros rápidos?"));
        card2.add(new JTextField(10));
        JButton but2 = new JButton("Next");
        mainPanel.add(card2);
        card2.add(but2);

        //card3 segunda pergunta
        JPanel card3 = new JPanel();
        card3.add(new JLabel("Qual animal o batman é?"));
        card3.add(new JTextField(10));
        JButton but3 = new JButton("Next");
        mainPanel.add(card3);
        card3.add(but3);

        //card4 terceira pergunta
        JPanel card4 = new JPanel();
        card4.add(new JLabel("quantas patas tem a girafa?"));
        card4.add(new JTextField(10));
        JButton but4 = new JButton("Next");
        mainPanel.add(card4);
        card4.add(but4);

        //card5 quarta pergunta
        JPanel card5 = new JPanel();
        card5.add(new JLabel("quem veio primeiro, o ovo ou a galinha?"));
        card5.add(new JTextField(10));
        JButton but5 = new JButton("Next");
        mainPanel.add(card5);
        card5.add(but5);

        
        //set do Frame
        this.setDefaultCloseOperation(2);//definindo a função do X do Frame
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);

    }
}
