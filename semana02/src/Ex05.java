//Crie um Loop que irá receber 10 nomes e após isso irá exibir os nomes e a posição deles na lista.
// Utilize um array(vertor) para esses exercício.

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        String[] nomes = new String[10];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < nomes.length; i++) {
            nomes[i] = scanner.nextLine();
        }
        for (int i = 0; i < nomes.length; i++) {
            System.out.println("Lista de nomes: " + nomes[i]);
            System.out.println("Posição dos nomes: " + i);
        }
    }
}
