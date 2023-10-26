package CarrosArrayList;

import java.util.*;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {

        // criar classe carros - Atributos e os Métoodos - ok
        // App
        List<Carros> listaCarros = new ArrayList<>();
        boolean aberto = true;
        while (aberto) {
            int acao = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Cadastrar\n2 - Listar"));

            if (acao == 1) {// 1- Cadastrar carros na lista
                // criar um objeto
                String marcaCar = JOptionPane.showInputDialog(null, "Marca Carro:");
                String ModeloCar = JOptionPane.showInputDialog(null, "Modelo Carro:");
                String anoCar = JOptionPane.showInputDialog(null, "Ano do Carro:");
                String corCar = JOptionPane.showInputDialog(null, "Cor do Carro:");
                Carros car = new Carros(marcaCar, ModeloCar, anoCar, corCar);
                listaCarros.add(car);

            } else if (acao == 2) {// 2- Listar Carros Cadastrados
                String listar = "";
                for (Carros carros : listaCarros) {
                    listar += carros.imprimirLN();
                }
                JOptionPane.showMessageDialog(null, listar);
            } else if (acao == 3) {
                String listar = "";
                int i = 0;
                for (Carros carros : listaCarros) {
                    listar += i + carros.imprimirLN();
                    i++;
                }
                int acao2 = Integer.parseInt(
                        JOptionPane.showInputDialog(
                                "Escolah o Carro:\n" + listar));
                listaCarros.get(acao2).imprimir();
            } else if (acao == 4) {
                String listar = "";
                int i = 0;
                for (Carros carros : listaCarros) {
                    listar += i + carros.imprimirLN();
                    i++;
                }
                int acao2 = Integer.parseInt(
                        JOptionPane.showInputDialog(
                                "Escolha o Carro Para Excluir:\n" + listar));
                listaCarros.get(acao2).imprimir();
                listaCarros.remove(acao2);
            }

            // 3-Consultar um Carro Cadastrado
            // 4- Apagar um Carro Cadastrado

        }
    }
}
