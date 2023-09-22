import javax.swing.*;
import java.awt.*;

public class AtividadeCardLayout extends JFrame{
    //construtor
    public AtividadeCardLayout() {
        super("CardLayout");
        JPanel painel1 = new JPanel();//principal
        //crianddo botão
        JButton bt = new JButton();
        painel1.add(bt);
        //criar os cards
        JPanel cards = new JPanel();//card principal - vai permitir a navegação pelos cards 
        CardLayout cl = new CardLayout();
        cards.setLayout(cl);
        //criar os cards da pilha
        JPanel card1 = new JPanel();
        card1.add(new );

    }
}
