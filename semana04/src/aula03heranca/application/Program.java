package aula03heranca.application;

import aula03heranca.entities.Circulo;
import aula03heranca.entities.Retangulo;
import aula03heranca.entities.Forma;
import aula03heranca.enums.Cor;

public class Program {
    public static void main(String[] args) {
        Forma f1 = new Retangulo(Cor.Black, 3.0, 4.0);
        Forma f2 = new Circulo(Cor.White, 2.0);

        System.out.println("A cor do retangulo é: " + f1.getCor() + "\nA área é: " + String.format("%.3f", f1.area()));
        System.out.println("A cor do círculo é: " + f2.getCor() + "\nA área é: " + String.format("%.3f", f2.area()));
    }
}
