import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PreenchimentoVetor {
    public static void main(String[] args) {
        List<Integer> listaNumeros = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nDigite um valor: ");
            int valor = sc.nextInt();

            if (valor > 50) {
                System.out.println("O valor fornecido deve ser menor que 50!");
            } else {
                listaNumeros.add(valor);
                break; 
            }
        }

        while (listaNumeros.size() < 10) {
            int ultimoValor = listaNumeros.get(listaNumeros.size() - 1);
            listaNumeros.add(ultimoValor * 2);
        }

        System.out.println("Lista de valores:");
        for (int i = 0; i < listaNumeros.size(); i++) {
            System.out.println("X[" + i + "] = " + listaNumeros.get(i));
        }

        sc.close();
    }
}
