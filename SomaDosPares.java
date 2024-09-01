import java.util.Scanner;

public class SomaDosPares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nDigite um valor (digite 0 para sair): ");
            int valor = sc.nextInt();

            if (valor == 0) {
                System.out.println("Encerrando o programa...");
                break; 
            }

            int soma = 0;
            int numeroAtual = valor;

            if (numeroAtual % 2 != 0) {
                numeroAtual++;
            }

            soma += numeroAtual;

            for (int i = 0; i < 4; i++) {
                numeroAtual += 2;
                soma += numeroAtual;
            }

            System.out.println("A soma é: " + soma);
        }

        sc.close();
    }
}
