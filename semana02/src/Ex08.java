//Recrie o programa do exercicio 6 e o coloque dentro de um bloco try-catch. Coloque um catch para o
// NullPointerException e um catch para uma Exception Genérica.

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            ArrayList<String> listaNomes = new ArrayList<>();

            String nome = "";

            do {
                System.out.println("Insira um nome na lista (digite 'fim' para finalizar):");
                nome = in.nextLine();

                if (!nome.equals("fim")) {
                    listaNomes.add(nome);
                }

            } while (!nome.equals("fim"));

            PriorityQueue<String> listaOrdenada = new PriorityQueue<>(listaNomes);
            listaOrdenada.forEach(itemLista -> System.out.println(itemLista));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Exception");
        }
    }
}
