//Adicione um loop á calculadora, onde ela deve realizar operações até receber a palavra "fim"
// na opção de operação.

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int operacao = 0;

        while (operacao != 5) {
            System.out.println("Selecione a operação que deseja calcular: \n 1 - soma \n 2 - subtração \n 3 - multiplicação \n 4 - divisão \n 5 - fim");
            operacao = in.nextInt();

            if (operacao != 5) {
                System.out.println("Digite o primeiro número:");
                int numero1 = in.nextInt();

                System.out.println("Digite o segundo número:");
                int numero2 = in.nextInt();

                switch (operacao) {
                    case 1:
                        System.out.println("Resultado: " + (numero1 + numero2));
                        break;
                    case 2:
                        System.out.println("Resultado: " + (numero1 - numero2));
                        break;
                    case 3:
                        System.out.println("Resultado: " + (numero1 * numero2));
                        break;
                    case 4:
                        System.out.println("Resultado: " + (numero1 / numero2));
                        break;
                    default:
                        System.out.println("Refaça a operação selecionando uma operação válida (de 1 a 4) ou 5 para encerrar.");
                }
            }
        }
    }
}
