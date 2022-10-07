//Após receber a palavra "fim" o program deve exibir os resultados de cada uma das contas realizadas até o
// presente momento. Utilize um array ou Array List para realizar essa tarefa.


import java.util.ArrayList;
import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        int operacao = 0, resultado = 0;

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
                        resultado = numero1 + numero2;
                        arrayList.add(String.valueOf(numero1) + "+" + String.valueOf(numero2) + "=" + String.valueOf(resultado));
                        break;
                    case 2:
                        resultado = numero1 - numero2;
                        arrayList.add(String.valueOf(numero1) + "-" + String.valueOf(numero2) + "=" + String.valueOf(resultado));
                        break;
                    case 3:
                        resultado = numero1 * numero2;
                        arrayList.add(String.valueOf(numero1) + "*" + String.valueOf(numero2) + "=" + String.valueOf(resultado));
                        break;
                    case 4:
                        resultado = numero1 / numero2;
                        arrayList.add(String.valueOf(numero1) + "/" + String.valueOf(numero2) + "=" + String.valueOf(resultado));
                        break;
                    default:
                        System.out.println("Refaça a operação selecionando uma operação válida (de 1 a 4) ou 5 para encerrar.");
                }
                System.out.println("Resultado: " + resultado);
            }
            if (operacao == 5) {
                System.out.println("Resumo das operações realizadas: " + arrayList);
            }
        }
    }
}
