package Exception;

import javax.swing.JOptionPane;

public class ExemploThrow {
    public static void main(String[] args) {
        boolean ativo = true;
        while (ativo) {

            String senhaDigitada = JOptionPane.showInputDialog("Digite uma senha");

            try {
                if (senhaDigitada.length() != 6) {
                    throw new Exception("Senha Inválida!");
                }
                ativo = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

}
