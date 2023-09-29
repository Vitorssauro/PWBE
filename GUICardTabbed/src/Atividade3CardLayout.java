import javax.swing.*;

import java.awt.*;

public class Atividade3CardLayout extends JFrame {
    public Atividade3CardLayout() {
        super("Exercicio 3 - HLC");
        //criar um Painel Principal -> CardLayout
        JPanel mainPanel = new JPanel();
        CardLayout cl = new CardLayout();
        mainPanel.setLayout(cl);
        //add painel principal ao frame
        this.add(mainPanel);
        //criar os cards da aplicação
        //card1- tela Início
        JPanel card1 = new JPanel();
        card1.add(new JLabel("Tela Inicial - Seja Bem Vindo"));
        JButton but1 = new JButton("Ir para Login");
        JButton but2 = new JButton("Ir para Cadastro");
        card1.add(but1);
        card1.add(but2);
        mainPanel.add(card1,"Inicio");
        //card2- tela de Login
        JPanel card2 = new JPanel();
        card2.add(new JLabel("Tela Login - Faça seu Login"));
        JButton but3 = new JButton("Ir para Início");
        JButton but4 = new JButton("Ir para Cadastro");
        card2.add(but3);
        card2.add(but4);
        mainPanel.add(card2,"Login");
        //card3- tela de Cadastro
        JPanel card3 = new JPanel();
        card3.add(new JLabel("Tela Cadastro - Faça seu Cadastro"));
        JButton but5 = new JButton("Ir para Início");
        JButton but6 = new JButton("Ir para Login");
        card3.add(but5);
        card3.add(but6);
        mainPanel.add(card3,"Cadastro");
        //set do Frame
        this.setDefaultCloseOperation(2);//definindo a função do X do Frame
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);
        //
    }
}
