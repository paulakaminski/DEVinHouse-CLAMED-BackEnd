//exercicio 02
//Agora que temos a superclasse pessoa, crie subclasses para cada tipo de participante do DEVinHouse:
// 1. Aluno (atributos: curso, matricula);
// 2. Mentor (atributos: linguagemDeProgramacao);
// 3. Coordenador (atributos: quantidadeCursosCoord).
// Cada subclasse deve herdar os atributos e métodos da superclasse e adicionar os atributos de cada subclasse.
// Lembre-se dos construtores, getters e setters.

//exercicio 03
//Crie um método na superclasse para obter as informações da pessoa. Este método pode se chamar obterInformacoes().
// Utilize a mesma identificação do método nas subclasses.

package exerciciosSemana04.entities;

public class Mentor extends Pessoa {
    //atributos
    private String linguagemDeProgramacao;

    //construtor padrao
    public Mentor(){
        super();
    }

    //construtor argumentos
    public Mentor(String nome, Integer idade, String linguagemDeProgramacao){
        super(nome, idade);
        this.linguagemDeProgramacao = linguagemDeProgramacao;
    }

    //getters e setters
    public String getLinguagemDeProgramacao(){
        return linguagemDeProgramacao;
    }

    public void setLinguagemDeProgramacao(String linguagemDeProgramacao){
        this.linguagemDeProgramacao = linguagemDeProgramacao;
    }

    //métodos
    //exercicio 02
    @Override
    public void obterInformacoes() {
        if ((getNome() == null) || (getNome().isEmpty() == true) || (getNome().split(" ").length < 2)) {
            throw new IllegalArgumentException("Deve ser informado o nome completo.");
        } else {
            System.out.println("Informações do Mentor:");
            System.out.println("Nome: " + getNome() + "\nIdade: " + getIdade() + "\nLinguagem de Programação: " + linguagemDeProgramacao);

        }
    }
}
