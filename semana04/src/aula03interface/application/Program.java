package aula03interface.application;

import aula03interface.entities.Circulo;
import aula03interface.entities.Retangulo;
import aula03interface.entities.FormaAbstrata;
import aula03interface.enums.Cor;

public class Program {
    public static void main(String[] args) {
        FormaAbstrata f1 = new Retangulo(Cor.Black, 3.0, 4.0);
        FormaAbstrata f2 = new Circulo(Cor.White, 2.0);

        System.out.println("A cor do retangulo é: " + f1.getCor() + "\nA área é: " + String.format("%.3f", f1.area()));
        System.out.println("A cor do círculo é: " + f2.getCor() + "\nA área é: " + String.format("%.3f", f2.area()));
    }
}
