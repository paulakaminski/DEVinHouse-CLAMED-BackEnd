package aula02.construtores;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        Pessoa pessoa1 = new Pessoa("Marcel", 29);
        Pessoa pessoa2 = new Pessoa(29, "99999999999");

        System.out.println(pessoa1);
        System.out.println(pessoa2);
    }
}
