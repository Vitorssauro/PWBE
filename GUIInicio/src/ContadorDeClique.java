import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContadorDeClique extends JFrame {
    private JPanel panel;
    private JButton button;
    private JLabel label;
    private int contador = 0;

    public ContadorDeClique() {
        panel = new JPanel();
        button = new JButton("Clique Aqui!");
        label = new JLabel("Contagem: " + contador);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador++;
                label.setText("Contagem: " + contador);
            }
        });

        panel.add(button);
        panel.add(label);

        add(panel);

        setTitle("Contador de Cliques");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ContadorDeClique();
            }
        });
    }
}