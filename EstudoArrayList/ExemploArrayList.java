package EstudoArrayList;

import java.util.ArrayList;
import java.util.Random;

public class ExemploArrayList {
    // atributo
    // Declarando o ArrayLiist do Tipo String
    Random rs = new Random();

    public void teste() {
        ArrayList<String> carros = new ArrayList<>();

        // Adicionar Valores ao ArrayList
        carros.add("Uno");
        carros.add("Chevette");
        carros.add("Celta");
        carros.add("Monza");
        carros.add("Gol");

        // Imprimitr toda a Lista
        System.out.println(carros);

        // pegando ao valor correspondente a 5 posição(index 4)
        System.out.println(carros.get(4));

        // percorrendo a lista com o FOR
        for (String i : carros) {
            System.out.println(i);
        }

        // apagar a lista
        carros.clear();
        System.out.println(carros);
    }

    public void exercicio() {
        ArrayList<Integer> n = new ArrayList<>();
        n.add(1);        
        n.add(2);
        n.add(3);
        n.add(4);        
        n.add(5);
        for (int i : n) {
            System.out.println(i);
        }
    }
}
