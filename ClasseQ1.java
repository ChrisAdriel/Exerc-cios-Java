public interface intQ1 {
    void impressao(int resultado, int k, int n);
    int potencia(int k, int n);
}


import java.util.Scanner;

class RecQ1 implements intQ1 {
    
    @Override
    public int potencia(int k, int n) {
        if (n == 0) {
            return 1;
        } else {
            return k * potencia(k, n - 1);
        }
    }

    @Override
    public void impressao(int resultado, int k, int n) {
        System.out.println(k + " elevado a " + n + " é = " + resultado);
    }
}

public class ClasseQ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RecQ1 q1 = new RecQ1();
        System.out.println("\nDigite o valor de K: ");
        int k = sc.nextInt();
        System.out.println("\nDigite o valor de n: ");
        int n = sc.nextInt();
        int resultado = q1.potencia(k, n);
        q1.impressao(resultado, k, n);
        System.out.println("Finalizando a execução do programa...");
        
    }
}
