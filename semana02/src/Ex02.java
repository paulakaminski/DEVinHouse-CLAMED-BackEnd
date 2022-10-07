//Crie uma calculadora que irá receber 2 número e um operador(soma, subtracao, multiplicacao ou divisao) e
// esse programa deve retornar o valor da operação realizada

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Selecione a operação que deseja calcular: \n 1 - soma \n 2 - subtração \n 3 - multiplicação \n 4 - divisão");
        int operacao = in.nextInt();

        System.out.println("Digite o primeiro número:");
        int numero1 = in.nextInt();

        System.out.println("Digite o segundo número:");
        int numero2 = in.nextInt();

        switch (operacao) {
            case 1:
                System.out.println("Resultado: " + (numero1+numero2));
                break;
            case 2:
                System.out.println("Resultado: " + (numero1-numero2));
                break;
            case 3:
                System.out.println("Resultado: " + (numero1*numero2));
                break;
            case 4:
                System.out.println("Resultado: " + (numero1/numero2));
                break;
            default:
                System.out.println("Refaça a operação selecionando uma operação válida (de 1 a 4).");
        }
    }
}
