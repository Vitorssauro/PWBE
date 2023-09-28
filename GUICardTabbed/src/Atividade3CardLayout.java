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
