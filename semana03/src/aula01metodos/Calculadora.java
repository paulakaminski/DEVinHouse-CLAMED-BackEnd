package aula01metodos;

import java.util.ArrayList;
import java.util.List;

public class Calculadora {
    List<Double> historicoResultado = new ArrayList<>();

    public Double soma(Double num1, Double num2) {
        Double resultado = num1 + num2;
        System.out.println("Resultado:");
        historicoResultado.add(resultado);
        return resultado;
    }

    public Double multiplicacao(Double num1, Double num2) {
        Double resultado = num1 * num2;
        System.out.println("Resultado:");
        historicoResultado.add(resultado);
        return resultado;
    }

    public Double subtracao(Double num1, Double num2) {
        Double resultado = num1 - num2;
        System.out.println("Resultado:");
        historicoResultado.add(resultado);
        return resultado;
    }

    public Double divisao(Double num1, Double num2) {
        Double resultado = num1 / num2;
        System.out.println("Resultado:");
        historicoResultado.add(resultado);
        return resultado;
    }

    public void printResultado() {
        historicoResultado.forEach(resultado -> System.out.println("Histórico de resultados: " + resultado));
    }
}
