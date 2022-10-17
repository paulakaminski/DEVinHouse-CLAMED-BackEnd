package aula01metodos;

public class Main {
    public static void main(String[] args) {
        helloWorld();

        Calculadora calculadora = new Calculadora();
        ;
        System.out.println(calculadora.soma(10.0, 10.0));

        System.out.println(calculadora.divisao(10.00, 2.00));
        System.out.println(calculadora.subtracao(10.00, 2.00));
        System.out.println(calculadora.multiplicacao(10.00, 2.00));

        calculadora.printResultado();
    }

    public static void helloWorld() {
        System.out.println("Hello World");
    }
}
