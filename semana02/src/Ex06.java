//Crie uma lista de nomes com Array List e salve nomes incluidos pelo usuário até receber a palavra "fim",
// a inclusão de nomes deve ser feita através do loop Do While.
// Os nomes da lista devem ser ordenados em ordem alfabética e exibidos na tela um a um.

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
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
    }
}
