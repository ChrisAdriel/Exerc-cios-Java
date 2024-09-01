
public interface intQ2 {
    void impressao(int resultado, int n);
    int contD(int n);
}

import java.util.Scanner;

class RecQ2 implements intQ2 {
    
    @Override
    public int contD(int n) {
        return contDRec(n, 0);
    }
    
    private int contDRec(int n, int cont) {
        if (n == 0) {
            return cont;
        } else {
            return contDRec(n / 10, cont + 1);
        }
    }

    @Override
    public void impressao(int resultado, int n) {
        System.out.println("O número " + n + " tem " + resultado + " dígito(s).");
    }
}

public class ClasseQ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RecQ2 recQ2 = new RecQ2();
        System.out.println("\nDigite o número: ");
        int n = sc.nextInt();
        int resultado = recQ2.contD(n);
        recQ2.impressao(resultado, n);
        System.out.println("Finalizando a execução do programa...");
    }
}
