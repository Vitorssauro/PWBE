import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JButtonAndJLabel {// não usa extends
    // Atributos
    int cont;

    // construtor
    public JButtonAndJLabel() {
        // criar um JFrame - Janela básica para uma aplicação
        JFrame janela = new JFrame("Janela Principal");
        JPanel painel = new JPanel();// Painel(container)
        // adicionar o painel ao frame
        janela.getContentPane().add(painel);//
        // Criar Componentes
        JButton button = new JButton("Clique Aqui!!!");
        JLabel text = new JLabel("Nº de Cliques");
        // adicionar os componentes ao painel
        painel.add(button);
        painel.add(text);
        // configurações da janela
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.pack();// organiza o tamanho da janela
        janela.setVisible(true);
        // action Listener (ação para o botão)

        button.addActionListener(e -> {
            while (cont < 10000) {
                cont++;
                painel.add(new JButton("" + cont));
                text.setText("Nº de Cliques: " + cont);
                janela.pack();
            }

        });
    }

}