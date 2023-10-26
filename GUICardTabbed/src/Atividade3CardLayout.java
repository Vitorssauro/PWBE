<<<<<<< HEAD
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
=======
import javax.swing.*;
import java.awt.*;

public class Atividade3CardLayout extends JFrame{
    public Atividade3CardLayout() {
        super("Exercicio 3");
        //painel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        this.add(mainPanel);//
        //add um painel de cards ao centro -> CardLayout
        CardLayout cl = new CardLayout();//layout do painel 
        JPanel cardPanel = new JPanel(cl); //criação do painel no layout
        mainPanel.add(cardPanel,BorderLayout.CENTER);
        //criar os paineis do cardLayout
    
        JPanel menu = new JPanel(new GridLayout(4,1));//Menu
        menu.add(new JLabel("Menu"));
        cardPanel.add(menu,"Menu");
        menu.add(new JButton("Login"));
        menu.add(new JTextField(""));

        JPanel login = new JPanel();//Login
        login.add(new JLabel("Login"));
        cardPanel.add(login,"Login");
        JPanel cadastro = new JPanel();//Cadastro
        cadastro.add(new JLabel("Cadastro"));
        cardPanel.add(cadastro,"Cadastro");
        
        //set do Frame
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);
        };
    }
>>>>>>> 2ac652b1869c451f1c2b8a96bb8d9937507d5917
