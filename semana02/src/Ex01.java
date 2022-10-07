//Crie um programa que receba 2 dados escritos pelo usuário e realize uma soma entre esses número e exiba
// o resultado no terminal.

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite um número:");
        int numero1 = in.nextInt();

        System.out.println("Digite mais um número:");
        int numero2 = in.nextInt();

        int soma = numero1 + numero2;

        System.out.println("A soma dos dois números é: " + soma);
    }
}
