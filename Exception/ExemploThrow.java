package Exception;

import javax.swing.JOptionPane;

public class ExemploThrow {
    public static void main(String[] args) {
        boolean ativo = true;
        while (ativo) {
            String loginDigitado = JOptionPane.showInputDialog("Informe seu Login:");
            String senhaDigitada = JOptionPane.showInputDialog("Informe sua Senha:");

            try {
                if (loginDigitado.equals(senhaDigitada)) {
                    throw new Exception("Login não pode ser igual a Senha!");
                }
                if (senhaDigitada.length() != 6) {
                    throw new Exception("A senha precisa ter 6 dígitos!");
                }
                ativo = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        JOptionPane.showMessageDialog(null,"Cradastado!!1!");
    }

}
