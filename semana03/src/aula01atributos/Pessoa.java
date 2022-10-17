package aula01atributos;

public class Pessoa {
    String nome;
    Integer idade;
    String paisOrigem;

    @Override
    public String toString() {
        return "Atributos.Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", paisOrigem='" + paisOrigem + '\'' +
                '}';
    }
}
