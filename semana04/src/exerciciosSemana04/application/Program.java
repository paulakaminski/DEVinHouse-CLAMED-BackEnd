package exerciciosSemana04.application;

import exerciciosSemana04.entities.Aluno;
import exerciciosSemana04.entities.Coordenador;
import exerciciosSemana04.entities.Mentor;
import exerciciosSemana04.entities.Pessoa;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String categoria;

        System.out.print("Digite a categoria - Aluno, Coordenador ou Mentor: ");
        categoria = scanner.nextLine();

        switch (categoria) {
            case "Aluno":
                try {
                    System.out.print("Nome completo: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    System.out.print("Curso: ");
                    String curso = scanner.next();
                    System.out.print("Matrícula: ");
                    int matricula = scanner.nextInt();

                    Pessoa pessoa1 = new Aluno(nome, idade, curso, matricula);
                    pessoa1.obterInformacoes();
                } catch (IllegalArgumentException e) {
                    System.out.print("Error: " + e.getMessage());
                } finally {
                    System.out.println("\nOperação finalizada.");
                }
                break;
            case "Coordenador":
                try {
                    System.out.print("Nome completo: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    System.out.print("Quantidade de cursos que coordena: ");
                    int qtdeCursosCoord = scanner.nextInt();

                    Pessoa pessoa2 = new Coordenador(nome, idade, qtdeCursosCoord);
                    pessoa2.obterInformacoes();
                } catch (IllegalArgumentException e) {
                    System.out.print("Error: " + e.getMessage());
                } finally {
                    System.out.println("\nOperação finalizada.");
                }
                break;
            case "Mentor":
                try {
                    System.out.print("Nome completo: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    System.out.print("Linguagem de Programação: ");
                    String linguagemDeProgramacao = scanner.next();

                    Pessoa pessoa3 = new Mentor(nome, idade, linguagemDeProgramacao);
                    pessoa3.obterInformacoes();
                } catch (IllegalArgumentException e) {
                    System.out.print("Error: " + e.getMessage());
                } finally {
                    System.out.println("\nOperação finalizada.");
                }
                break;
            default:
                System.out.print("Refaça a operação informando uma categoria válida.");
        }
        scanner.close();
    }
}
