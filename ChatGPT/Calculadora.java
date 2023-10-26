package ChatGPT;

    import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora de Divisão");
        System.out.print("Digite o primeiro número: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        double numero2 = scanner.nextDouble();

        // Verifica se o divisor é zero para evitar divisão por zero
        if (numero2 == 0) {
            System.out.println("Não é possível dividir por zero. Encerrando o programa.");
        } else {
            // Realiza a divisão e armazena o resultado em uma variável
            double resultado = numero1 / numero2;

            // Exibe o resultado
            System.out.println("O resultado da divisão é: " + resultado);
        }

        scanner.close();
    }
}
