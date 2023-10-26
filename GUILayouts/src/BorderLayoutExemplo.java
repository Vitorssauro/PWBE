import javax.swing.*;
import java.awt.*;

public class BorderLayoutExemplo {
    public BorderLayoutExemplo() {
        super();
        JFrame janelaP = new JFrame("Janela Principal");
        // mudando o Layout para BorderLayoutdo JFrame
        BorderLayout border = new BorderLayout();
        janelaP.setLayout(border);
        janelaP.add(new JButton("West"), BorderLayout.WEST);
        janelaP.add(new JButton("East"), BorderLayout.EAST);
        janelaP.add(new JButton("Center"), BorderLayout.CENTER);
        janelaP.add(new JButton("North"), BorderLayout.NORTH);
        janelaP.add(new JButton("South"), BorderLayout.SOUTH);
        // set JFrame
        janelaP.setDefaultCloseOperation(2);
        janelaP.pack();
        janelaP.setVisible(true);

    }
}
