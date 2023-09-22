import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ContainerComponents extends JFrame {
    public ContainerComponents() {

        super("Exemplo Janela");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(200, 200, 400, 400);
        // determinando o Layout da Janela
        // FlowLayout flow = new FlowLayout();
        // this.setLayout(flow);
        // Utilizando um novo Container
        JPanel painel = new JPanel();// por padrão é um FlowLayout
        this.getContentPane().add(painel);
        for (int i = 0; i < 6; i++) {
            painel.add(new JButton("Number " + i));
        }
        this.setVisible(true);

    }

}
