package aula01atributos;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        pessoa.nome = "Paula";
        pessoa.idade = 30;
        pessoa.paisOrigem = "Brasil";
        System.out.println(pessoa.toString());

        Pessoa pessoa1 = new Pessoa();
        pessoa1.nome = "Marcel";
        pessoa1.idade = 29;
        pessoa1.paisOrigem = "Brasil";
        System.out.println(pessoa1.toString());

        //       objeto
        Cachorro cachorro = new Cachorro();
        cachorro.nome = "Scooby Doo";
        cachorro.sexo = 'M';
        cachorro.idade = 4;
        cachorro.raca = "Pitbull";
        System.out.println(
                "Nome: " + cachorro.nome
                        + "Idade: " + cachorro.idade
                        + "Raça: " + cachorro.raca
                        + "Sexo: " + cachorro.sexo
        );

        Cachorro cachorro2 = new Cachorro();
        System.out.println(
                "Nome: " + cachorro2.nome + "; "
                        + "Idade: " + cachorro2.idade + "; "
                        + "Raça: " + cachorro2.raca + "; "
                        + "Sexo: " + cachorro2.sexo + "; "
        );
    }
}
